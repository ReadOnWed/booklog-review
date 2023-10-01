package com.booklog.review.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;

@Configuration
public class EnvironmentConfig {
	private static String BOOK_API_HOST;

	@Value("${spring.profiles.active}")
	private String profilesActive;

	@PostConstruct
	public void init(){
		if("local".equals(profilesActive)){
			BOOK_API_HOST = "http://localhost:8081";
		}
		else if("prod".equals(profilesActive)){
			BOOK_API_HOST = "http://booklog-book.com";
		}
	}

	public static String getBookApiHost(){
		return BOOK_API_HOST;
	}
}
