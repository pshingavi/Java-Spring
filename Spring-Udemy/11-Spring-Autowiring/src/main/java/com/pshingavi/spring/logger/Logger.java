package com.pshingavi.spring.logger;

import org.springframework.beans.factory.annotation.Autowired;

public class Logger {
	private LogWriter fileWriter;
	// Doesn't need a set method, looks at the type
	@Autowired
	private LogWriter consoleWriter;
	
	
	public LogWriter getFileWriter() {
		return fileWriter;
	}

	// This type of autowiring on set methods depends on type passed
	@Autowired
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public LogWriter getConsoleWriter() {
		return consoleWriter;
	}
	/*public void setConsoleWriter(LogWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}*/
	
	public void writeToFile() {
		fileWriter.write();
	}
	
	public void writeToConsole() {
		consoleWriter.write();
	}
}
