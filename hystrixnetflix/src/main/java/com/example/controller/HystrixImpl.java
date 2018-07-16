package com.example.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Component
public class HystrixImpl {
	
	@Autowired
	private BackEndServices backEndService;

	private RestTemplate restTemplate;
	
	private ResponseEntity<String> exchange=null;

	@HystrixCommand(fallbackMethod="defaultFallbackGetDetails")
	public ResponseEntity<String> getDetails() {
		try {
			System.out.println("***********************Inside Main*********************************");
			URI endPoint=URI.create("https://localhost:8083/getDetails");
			return restTemplate.getForEntity(endPoint, String.class);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
	public ResponseEntity<String> defaultFallbackGetDetails()
	{
		    System.out.println("***********************Inside Fallback*******************************");
			URI endPoint=URI.create("https://localhost:8084/getDetails");
			return restTemplate.getForEntity(endPoint, String.class);	
	}
	

	@HystrixCommand(fallbackMethod = "defaultFallbackCallGetData")
	public String getData(){
		try{
			System.out.println("*********************Inside Main*******************");
			return backEndService.getData();	
		}catch(Exception e){
			throw new RuntimeException();
		}
		
		
	}
	
	public String defaultFallbackCallGetData(){
		System.out.println("*********************Inside fallback*******************");
		return "fallback";	
}

}
