package com.example.errormanagement;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class errorManagement {

	@RequestMapping(value="/getException",method=RequestMethod.GET)
	public void getErrorMessage() throws RuntimeException
	{
		int i=1/0;
	   int[] intArray = new int[2];
	   intArray[0]=1;
	   intArray[1]=2;
	   intArray[2]=3;
	   intArray[3]=4;
	}
}
