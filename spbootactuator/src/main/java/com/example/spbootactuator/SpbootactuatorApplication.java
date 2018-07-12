package com.example.spbootactuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages="com.example.customeactuator,com.example.errormanagement,com.example.testcase")
public class SpbootactuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpbootactuatorApplication.class, args);
	}
}
//logging & logback & actuator & custome actuator & Unite Test Case