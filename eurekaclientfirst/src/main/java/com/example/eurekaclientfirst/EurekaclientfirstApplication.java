package com.example.eurekaclientfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages="com.example.controller")
public class EurekaclientfirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientfirstApplication.class, args);
	}
}
