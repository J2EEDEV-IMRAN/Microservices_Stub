package com.example.controller;


import org.springframework.stereotype.Component;

@Component
public class BackEndServices {

	public String getData() throws InterruptedException{
		
		Thread.sleep(15000);
		return "HelloHystrix";
	}
}