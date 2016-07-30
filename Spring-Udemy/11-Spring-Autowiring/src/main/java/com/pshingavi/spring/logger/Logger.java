package com.pshingavi.spring.logger;

public class Logger {
	private LogWriter fileWriter;
	private LogWriter consoleWriter;
	
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
}
