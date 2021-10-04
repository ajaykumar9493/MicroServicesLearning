package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
public class CircuitBreaker_Retry {

	Logger logger=LoggerFactory.getLogger(CircuitBreaker_Retry.class);

	@GetMapping("TestApi")
//	@Retry(name="sample-api",fallbackMethod = "fallBackMethod")
	@CircuitBreaker(name="default",fallbackMethod = "fallBackMethod")
	@RateLimiter(name = "default")
	@Bulkhead(name="default")
	public String retryMethod() {
		logger.info(">> Inside Retry Method ::: \n");
		ResponseEntity<String> resEntity= new RestTemplate().getForEntity("http://localhost:856/testApi",String.class);
		return resEntity.getBody();
		//		return "TestApi";
	}
	
	
	public String fallBackMethod(Exception ex) {
		return "fall back-Method";
	}
}
