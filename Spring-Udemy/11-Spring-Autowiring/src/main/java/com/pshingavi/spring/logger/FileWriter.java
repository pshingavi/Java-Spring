package com.pshingavi.spring.logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FileWriter implements LogWriter {

	private String message = "default";
	
	// @Value, @Autowired and @Component (above class) gives a simulation of <bean><property name="message" value="something">
	@Autowired
	public void setMessage(@Value("Injected message") String message) {
		this.message = message;
	}
	
	public void write() {
		System.out.println("Writing to file message : " + message);
	}

}
