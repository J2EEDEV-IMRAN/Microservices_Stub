package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class NetflixController {
	@Autowired
	public HystrixImpl hystrixImpl;
	
	public ResponseEntity<String> exchange=null;

  @RequestMapping(value="/getDetails",method=RequestMethod.GET)
  public String getAccounts()
  {
	  try {
		  exchange=hystrixImpl.getDetails();
		  return exchange.getBody()+"Status Code :"+exchange.getStatusCodeValue();
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	  return null;
  }
  
  @RequestMapping("/getData")
	public String getData() {
		try{
			String data = hystrixImpl.getData();
			return data;
		}catch(Exception e){
			
		}
		return null;
		
}
  
}
