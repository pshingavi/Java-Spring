package com.pshingavi.spring.logger;

public class Logger {
	private LogWriter fileWriter;
	private LogWriter consoleWriter;
	
	
	// Autowiring by constructor checks by type
	// If autowired byName then error since we don't have default constructor
	public Logger(FileWriter fileWriter, ConsoleWriter consoleWriter) {
		this.fileWriter = fileWriter;
		this.consoleWriter = consoleWriter;
	}
	
	public LogWriter getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public LogWriter getConsoleWriter() {
		return consoleWriter;
	}
	public void setConsoleWriter(LogWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public void writeToFile() {
		fileWriter.write();
	}
	
	public void writeToConsole() {
		consoleWriter.write();
	}
}
