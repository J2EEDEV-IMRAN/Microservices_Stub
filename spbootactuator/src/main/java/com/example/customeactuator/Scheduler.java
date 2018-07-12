package com.example.customeactuator;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {

	//@Scheduled(fixedRate=2000)
	@Scheduled(cron = "*/10 * * * * *?")
	public void showScheduler()
	{
		System.out.println("**************Scheduled Task*************");
	}
	
}
