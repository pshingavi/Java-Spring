package com.expedia.pshingavi.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("allGetters() && allModelPackages()")	// use pointcut
	////@Before("execution(public * get*(..))")	// 0 or more args
	//@Before("execution(public * get*(*))")	// one argument
	public void LoggingAdvice() {
		System.out.println("Advice run. Get Method called");
	}
	
	@Before("allGetters()")	// use pointcut
	public void SecondAdvice() {
		System.out.println("Second advice executed.");
	}
	
	/**
	 * Use pointcut to reuse str expression in @Before etc
	 */
	@Pointcut("execution(* get*())") // execution point cut expression. 0 or more arguments
	public void allGetters() {}
	
	//@Pointcut("execution(* * com.expedia.pshingavi.model.Circle.*(..))")
	//@Pointcut("within(com.expedia.pshingavi.model.Circle)")	// Within Circle class
	//@Pointcut("within(com.expedia.pshingavi.model.*)")	// for all model but not sub packages
	@Pointcut("within(com.expedia.pshingavi.model..*)")	// for all model and sub packages
	public void allModelPackages() {
		
	}

}
