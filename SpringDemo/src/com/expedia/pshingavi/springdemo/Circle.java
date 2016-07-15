package com.expedia.pshingavi.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

	private Point center;
	
	public Point getCenter() {
		return center;
	}
	
	// In order to tell spring to handle NPE at init (BeanPostProcessor does this) and not wait till application fails
	@Autowired	// If Autowire fails to map type or name of bean handler passed to Qualifier
	@Qualifier("circleQualifier")	// See qualifier tag in pointA. This was not required if 
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Point : " + this.center.getX() + ", " + this.center.getY());
	}

}
