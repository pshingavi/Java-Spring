package com.pshingavi.spring.logger;

public class ConsoleWriter implements LogWriter {

	public void write() {
		System.out.println("Writing to console");
	}

}
