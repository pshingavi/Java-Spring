package com.pshingavi.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("robot")
public class Robot {
	
	private String id = "default id";
	private String speach = "Hello";
	
	// Also check ?. in the SPEL to handle NPE if any
	@Autowired
	public void setId(@Value("#{randomSpeach.generateRandomSpeach()?.length()}") String id) {
		this.id = id;
	}

	@Autowired
	// Example SPEL : 
	//1. Non static new java.util.Date().toString()
	//2. If it's a static variable or method then use T(Class).method()/variable.
		// Example Math.PI (won't work) use T(Math).PI
		// "#{T(Math).PI le 3}" => false (3.14 < 3) similar use eq, ge, ternary operator etc.
	public void setSpeach(@Value("#{randomSpeach.generateRandomSpeach()}") String speach) {
		this.speach = speach;
	}

	public void speak() {
		System.out.println(this.id + " Speach :" + this.speach);
	}
}
