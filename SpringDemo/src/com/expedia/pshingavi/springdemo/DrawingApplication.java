package com.expedia.pshingavi.springdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));	// File spring.xml is at project root
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		// File spring.xml is at src root, since we are using Class path app context
		Triangle triangle = ctx.getBean("triangle1", Triangle.class);
		Triangle triangle2 = ctx.getBean("triangle2", Triangle.class);
		//Triangle triangle = ctx.getBean("triangle2", Triangle.class);	// Gives a NPE since triangle2 is not init with pointC
		System.out.println("Triangle 1");
		triangle.draw();	// Has 3 points merged from parenttriangle template where abstract=true
		System.out.println("Triangle 2");
		triangle2.draw(); // Has only 1 point since merge="default" / false 
	}

}
