package com.bridgelabz.greetingapp.servicce;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;

public interface IGreetingService 
{
	Greeting addGreeting(User user);
}
