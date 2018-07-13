package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ServicePerson;

@RestController
@Cacheable("person")
public class ControllerPerson {

	@Autowired
	public ServicePerson servicePerson;
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ServicePerson getPersonData()
	{
		delay();
		servicePerson.setId(1);
		servicePerson.setName("imran hossain");
		servicePerson.setHeight("5.4");
		servicePerson.setAge("26");
		return servicePerson;
	}

	private void delay() {
		
		try {
			Thread.sleep(3000L);
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
