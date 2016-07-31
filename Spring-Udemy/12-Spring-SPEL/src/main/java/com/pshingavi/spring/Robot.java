package com.pshingavi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("robot")
public class Robot {
	
	private String id = "default id";
	private String speach = "Hello";
	
	// Autowire from property file
	@Autowired
	public void setId(@Value("${r0.id}") String id) {
		this.id = id;
	}

	//Autowire from property file
	@Autowired
	public void setSpeach(@Value("${r0.speach}") String speach) {
		this.speach = speach;
	}

	public void speak() {
		System.out.println(this.id + " Speach :" + this.speach);
	}
}
