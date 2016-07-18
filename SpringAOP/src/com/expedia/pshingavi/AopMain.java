package com.expedia.pshingavi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expedia.pshingavi.service.FactoryService;
import com.expedia.pshingavi.service.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		//pplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		FactoryService fs = new FactoryService();
		ShapeService shapeService = (ShapeService)fs.getBean("shapeService");
		//System.out.println(shapeService.getCircle().getName());
		shapeService.getCircle();	// calls ShapeServiceProxy.getCircle() which creates LoggingAspect to call loggingAdvice
	}
}