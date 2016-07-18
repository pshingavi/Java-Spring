package com.expedia.pshingavi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.expedia.pshingavi.model.Circle;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethods()")	// use pointcut
	public void LoggingAdvice(JoinPoint joinPoint) {	// joinPoint is place which triggered this (a method)
		System.out.println(joinPoint.toString());	// execution(String com.expedia.pshingavi.model.Circle.getName())
		Circle circle = (Circle) joinPoint.getTarget();
	}
	
	@Before("args(String)")
	public void stringArgsMethod() {
		System.out.println("Method with String argument has been called.");
		// Method with String argument has been called.
	}
	
	@Before("args(name)")
	public void stringArgsMethodParam(String name) {
		System.out.println("Method with String argument has been called : " + name);
		// Method with String argument has been called : Dummy circle
	}
	
	@Pointcut("within(com.expedia.pshingavi.model.Circle)")	// for all model and sub packages
	public void allCircleMethods() {}

}
