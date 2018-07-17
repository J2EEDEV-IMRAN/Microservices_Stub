package com.example.hystricsnetflix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableDiscoveryClient
@EnableHystrixDashboard
@EnableHystrix
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.controller")
public class HystricsnetflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(HystricsnetflixApplication.class, args);
	}
	@Bean
	public RestTemplate getTemplate(){
		return new RestTemplate();
}
}
