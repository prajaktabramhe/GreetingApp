package com.bridgelabz.greetingapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "greet")
public class Greeting 
{
	@Id
	private String message;
	private long id;
	
	public Greeting()
	{
		id = 0;
		message = "";
	}
	
	public Greeting(long id, String message) 
	{
		this.id = id;
		this.message = message;
	}
	

	public long getId() 
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
	}
	
	public String getmessage() 
	{
		return message;
	}
	public void setMessage(String name)
	{
		this.message = name;
	}
}
