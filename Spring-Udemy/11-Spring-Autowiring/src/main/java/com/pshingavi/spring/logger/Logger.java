package com.pshingavi.spring.logger;

public class Logger {
	private FileWriter fileWriter;
	private ConsoleWriter consoleWriter;
	
	public FileWriter getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public ConsoleWriter getConsoleWriter() {
		return consoleWriter;
	}
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
}
