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
	public void setSpeach(@Value("#{randomSpeach.generateRandomSpeach()}") String speach) {
		this.speach = speach;
	}

	public void speak() {
		System.out.println(this.id + " Speach :" + this.speach);
	}
}
