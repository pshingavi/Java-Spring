package com.pshingavi.spring.logger;

import org.springframework.stereotype.Component;

@Component
public class FileWriter implements LogWriter {

	public void write() {
		System.out.println("Writing to file");
	}

}
