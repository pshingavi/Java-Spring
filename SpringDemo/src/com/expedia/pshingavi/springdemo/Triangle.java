package com.expedia.pshingavi.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware{

	private Point pointA;
	private Point pointB;
	private Point pointC;
	private String beanName;
	
	private ApplicationContext ctx = null;
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public void draw() {
		System.out.println(this.getPointA().getX() + " :::: " + this.getPointA().getY());
		System.out.println(this.getPointB().getX() + " :::: " + this.getPointB().getY());
		System.out.println(this.getPointC().getX() + " :::: " + this.getPointC().getY());
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println(this.ctx);	// prints null
		System.out.println("Bean name is : " + this.beanName);
		
	}
}
