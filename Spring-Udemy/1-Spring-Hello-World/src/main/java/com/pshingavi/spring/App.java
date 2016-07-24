package com.pshingavi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /*Person person = new Person();
        person.speak();*/
    	
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
    	Person person = ctx.getBean("person", Person.class);
    	person.speak();
    	
    	((ClassPathXmlApplicationContext)ctx).close();
    }
}
