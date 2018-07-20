package com.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FristClientController {

	@RequestMapping(value="/getProjectName",method=RequestMethod.GET)
	public String getProjectName()
	{
		return "FRISTCLIENT";
	}
}
