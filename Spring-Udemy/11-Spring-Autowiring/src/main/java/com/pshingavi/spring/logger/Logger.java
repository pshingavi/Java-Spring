package com.pshingavi.spring.logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component
public class Logger {
	@Resource
	private LogWriter fileWriter;	// From @Component for Implementing class FileWriter
	// Doesn't need a set method, looks at the type
	@Resource(name="consoleWriter2")	// fROM SPRING.XML or if @Component("consoleWriter2") by impl class ConsoleWriter
	private LogWriter consoleWriter;
	
	public LogWriter getFileWriter() {
		return fileWriter;
	}

	public LogWriter getConsoleWriter() {
		return consoleWriter;
	}
	
	public void writeToFile() {
		fileWriter.write();
	}
	
	public void writeToConsole() {
		consoleWriter.write();
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Object Created !");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Object about to be destroyed");
	}
}
