package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ServicePerson;

@RestController
public class ControllerPerson {

	@Autowired
	public ServicePerson servicePerson;
	
	@RequestMapping(value="/getPersonData",method=RequestMethod.GET)
	public ServicePerson getPersonData()
	{
		servicePerson.setId(1);
		servicePerson.setName("imran hossain");
		servicePerson.setHeight("5.4");
		servicePerson.setAge("26");
		return servicePerson;
	}
}
