package com.pshingavi.spring;

public class Robot {

	private String speach = "Hello";
	
	public void setSpeach(String speach) {
		this.speach = speach;
	}

	public void speak() {
		System.out.println(this.speach);
	}
}
