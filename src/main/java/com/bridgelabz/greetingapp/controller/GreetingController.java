package com.bridgelabz.greetingapp.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	private IGreetingService greetingService;
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) 
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/greeting/{name}")
	public Greeting greetingNew(@RequestParam(value = "name") String name) 
	{
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@GetMapping("/message")
	public String message() {
		return greetingService.greet();
	}
	
	@PostMapping("/fullName")
	public String sayWow(@RequestBody User user) {
		String message = String.format(template, (user.toString().isEmpty()) ? "World" : user.toString());
		return message;
	}
}
