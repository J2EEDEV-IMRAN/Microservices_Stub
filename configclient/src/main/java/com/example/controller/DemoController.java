package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.ConfigProperties;

@RestController
public class DemoController {

	public ConfigProperties configProperties;
	
	@RequestMapping("/getConfiguration")
	public String getConfiguration()
	{
		return configProperties.getAppName();
	}
}
