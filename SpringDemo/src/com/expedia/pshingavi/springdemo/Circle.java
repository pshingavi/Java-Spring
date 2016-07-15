package com.expedia.pshingavi.springdemo;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

	private Point center;
	
	public Point getCenter() {
		return center;
	}
	
	// In order to tell spring to handle NPE at init (BeanPostProcessor does this) and not wait till application fails
	@Required
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing Circle");
		System.out.println("Point : " + this.center.getX() + ", " + this.center.getY());
	}

}
