package com.expedia.pshingavi.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.expedia.pshingavi.model.Circle;

//@Aspect	// transfered to spring.xml config
public class LoggingAspect {
	
	//@Around("@annotation(com.expedia.pshingavi.aspect.Loggable)")
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJointPoint) {
		Object returnValue = null;
		// Before
		try {
			System.out.println("Before Advice");
			
			returnValue = proceedingJointPoint.proceed();
			
			System.out.println("After returning");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
		} finally {
			System.out.println("After finally");
		}
		return returnValue;
	}

	// Moved to xml
	
	/*@Pointcut("execution(* get*())")
	public void allGetters() {}
*/
	
	public void loggingAdvice() {
		System.out.println("logging advice with proxy call");
	}

}
