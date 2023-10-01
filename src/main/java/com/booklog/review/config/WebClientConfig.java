package com.booklog.review.config;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.http.codec.LoggingCodecSupport;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;
import reactor.netty.http.client.HttpClient;

@Configuration
@Slf4j
public class WebClientConfig {
	@Bean
	public WebClient webClient(){
		// Spring Webflux 에서 codec 처리를 위한 in-memory buffer 의 디폴트 값은 256KB
		// 256KB 보다 큰 Http 메서드를 처리하려고 하면 DataBufferLimitException 예외 발생
		ExchangeStrategies exchangeStrategies= ExchangeStrategies.builder()
			.codecs(clientCodecConfigurer
				// 디폴트 in-memory buffer 값을 1MB로 설정
				-> clientCodecConfigurer.defaultCodecs().maxInMemorySize(1024*1024))
			.build();

		// ConnectionTimeOut을 5초로 세팅 (디폴트는 30초)
		HttpClient httpClient = HttpClient.create()
			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
			.responseTimeout(Duration.ofMillis(5000))
				.doOnConnected(connection -> {
					connection.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
						.addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS));
					});

		// 기본적으로 Webclient는 header 정보를 보여주지 않는다. (민감한 정보를 포함하고 있기 때문)
		// 하지만, 개발시에는 로깅을 통해 요청과 응답 정보를 확인하기 위해 로깅여부를 true로 설정
		// application.yml도 함께 수정하여 개발시에는 DEBUG 레벨로, 운영에서는 INFO 레벨과 그 이상의 정보를 로깅
		exchangeStrategies.messageWriters().stream()
			.filter(LoggingCodecSupport.class::isInstance)
			.forEach(httpMessageWriter
				-> ((LoggingCodecSupport)httpMessageWriter).setEnableLoggingRequestDetails(true));

		return WebClient.builder()
			// filter() 메소드를 통해 Request / Response 데이터를 조작 및 추가 작업
			// ExchangeFilterFunction.ofRequestProcessor() 메소드를 통해 clientRequest 를 변경 또는 출력
			.filter(ExchangeFilterFunction.ofRequestProcessor(
				clientRequest -> {
					log.debug("Request: {} {}", clientRequest.method(), clientRequest.url());
					clientRequest.headers()
						.forEach((name, values) -> values.forEach(value -> log.debug("{} : {}", name, value)));
					return Mono.just(clientRequest);
				}
			))
			// Response 에 대해서도 위와 동일한 작업 수행
			.filter(ExchangeFilterFunction.ofResponseProcessor(
				clientResponse -> {
					clientResponse.headers()
						.asHttpHeaders()
						.forEach((name, values) ->
							values.forEach(value -> log.debug("{} : {}", name, value)));
					return Mono.just(clientResponse);
				}
			))
			// ConnectionTimeOut 설정
			.clientConnector(new ReactorClientHttpConnector(httpClient))
			.build();
	}
}
