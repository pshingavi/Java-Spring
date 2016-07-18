package com.expedia.pshingavi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	@After("args(String)")
	public void stringArgsMethod() {
		System.out.println("Method with String argument has been called.");
		// Method with String argument has been called.
	}
	
	@After("args(name)")	// Like finally, runs even after exception
	public void stringArgsMethodParam(String name) {
		System.out.println("After : Method with String argument has been called : " + name);
		// Method with String argument has been called : Dummy circle
	}
	
	@AfterReturning(pointcut="args(name)", returning="returnString")	// Not executed if exception
	public void stringArgsMethodParamReturn(String name, String returnString) {
		System.out.println("After returning: Method takes : " + name);
		System.out.println("After returning: Method returns : " + returnString);
		// Method with String argument has been called : Dummy circle
	}
	
	@AfterThrowing(pointcut="args(name)", throwing="ex")	// run when method execution failed
	public void stringArgsMethodParamThrow(String name, RuntimeException ex) {
		System.out.println("Exception thrown : " + ex);
		// Method with String argument has been called : Dummy circle
	}
	
	@Pointcut("within(com.expedia.pshingavi.model.Circle)")	// for all model and sub packages
	public void allCircleMethods() {}

}
