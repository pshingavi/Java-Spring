package com.expedia.pshingavi.springdemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApplication {

	public static void main(String[] args) {
		//BeanFactory factory = new XmlBeanFactory(new FileSystemResource("spring.xml"));	// File spring.xml is at project root
		//ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		
		// To register ctx.close hook
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		ctx.registerShutdownHook();	// Destroy is called for all the beans. See in class Triangle to implement InitializingBean, DisposableBean
		// File spring.xml is at src root, since we are using Class path app context
		Shape triangleShape = ctx.getBean("triangle", Shape.class);
		System.out.println("Triangle 1");
		triangleShape.draw();	// Has 3 points merged from parenttriangle template where abstract=true
		Shape shapeCircle = ctx.getBean("circle", Shape.class);
		shapeCircle.draw();
		// Destroy for beans triangle1 and triangle2 called
	}

}
