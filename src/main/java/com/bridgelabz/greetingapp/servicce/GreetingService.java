package com.bridgelabz.greetingapp.servicce;

import org.springframework.stereotype.Service;


@Service
public class GreetingService implements IGreetingService
{
	
	@Override
	public String greet() 
	{
		return "Hello World";
	}
}
