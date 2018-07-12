package com.example.customeactuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id="firstcustomepoint")
public class CustomeActuator {
	 @ReadOperation
     public String getHello(){
         return "Hello" ;
     }
}
