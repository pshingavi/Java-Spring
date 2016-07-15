package com.expedia.pshingavi.springdemo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle {

	private List<Point> points;
	
	private String beanName;
	
	private ApplicationContext ctx = null;
	
	/*public Point getPointA() {
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
*/
	
	
	public void draw() {
/*		System.out.println(this.getPointA().getX() + " :::: " + this.getPointA().getY());
		System.out.println(this.getPointB().getX() + " :::: " + this.getPointB().getY());
		System.out.println(this.getPointC().getX() + " :::: " + this.getPointC().getY());
		*/
		for(Point point : this.points) {
			System.out.println(point.getX() + " :::: " + point.getY());
		}
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

/*	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx = ctx;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
		System.out.println(this.ctx);	// prints null
		System.out.println("Bean name is : " + this.beanName);
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Init bean for Triangle");
		
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle bean destroy called");
		
	}*/
	private void triangleInit() {
		System.out.println("My init called and not from InitilizingBean");

	}
	
	private void triangleDestroy() {
		System.out.println("My destroy called and not from DisposableBean");

	}
}
