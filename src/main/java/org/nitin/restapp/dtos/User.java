package org.nitin.restapp.dtos;

public class User {
	
	public String name;
	public int age;
	public long id;
	
	public User(String name,int age, long id)
	{
		this.name = name;
		this.age = age;
		this.id = id;
	}
	
	@Override
	public String toString() {
		return age +" "+ name + " "+ id;
	}
	

}
