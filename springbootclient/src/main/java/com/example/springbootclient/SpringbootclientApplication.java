package com.example.springbootclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages="com.example.controller")
public class SpringbootclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootclientApplication.class, args);
	}
}
