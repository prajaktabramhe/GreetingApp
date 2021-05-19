package com.bridgelabz.greetingapp.controller;



import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.model.User;
import com.bridgelabz.greetingapp.servicce.IGreetingService;

@RestController
@RequestMapping("")
public class GreetingController 
{
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
    @Autowired
	private IGreetingService iGreetingService;
	
	@GetMapping(value = {"/home"})
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name)
	{
		User user = new User();
		user.setFirstName(name);
		return iGreetingService.addGreeting(user);
	}
	
	@PostMapping("/fullName")
	public Greeting sayWow(@RequestBody User user) {
		return iGreetingService.addGreeting(user);
	}
		
	@GetMapping("/find/{id}")
	public Optional<Greeting> greeting(@PathVariable(value = "id") long id)
	{
		return iGreetingService.findById(id);
	}
	
	@GetMapping("/all")
	public List<Greeting> getAll(){
		return iGreetingService.getAll();
	}
	
	
}
