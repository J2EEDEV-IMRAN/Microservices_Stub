package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BakcupBackEnd {

	
	@RequestMapping("/getDetails")
	public String getDetails()
	{
		return "Main Service is not OK";
	}
	
}
