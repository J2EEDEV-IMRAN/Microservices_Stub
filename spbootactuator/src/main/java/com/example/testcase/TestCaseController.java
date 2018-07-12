package com.example.testcase;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCaseController
{
	@RequestMapping("/testresult")
	public String handleTest()
	{
		return "hellotest";
	}

}
