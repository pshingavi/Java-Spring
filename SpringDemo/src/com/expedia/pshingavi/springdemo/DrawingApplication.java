package com.expedia.pshingavi.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));	// File spring.xml is at project root
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		// File spring.xml is at src root, since we are using Class path app context
		Triangle triangle = ctx.getBean("triangle", Triangle.class);
		triangle.draw();
	}

}
