package com.expedia.pshingavi.springdemo.listener;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Draw event occured !";
	}

}
