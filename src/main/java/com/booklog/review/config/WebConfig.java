package com.booklog.review.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/v1/reviews/**") 	// v1/reviews/ 경로에 대해서 CORS 설정
			.allowedOrigins("http://localhost:3000") 		// 리액트 애플리케이션의 도메인을 설정
			.allowedMethods("GET", "POST", "PUT", "DELETE")
			.allowCredentials(true);
	}
}