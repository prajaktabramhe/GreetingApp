package com.bridgelabz.greetingapp.servicce;

import java.util.List;
import java.util.Optional;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;



public interface IGreetingService 
{
	Greeting addGreeting(User user);

	Optional<Greeting> findById(long id);

	List<Greeting> getAll();

	

}
