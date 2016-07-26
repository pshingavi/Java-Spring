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
    	Person p2 = ctx.getBean("person", Person.class);
    	System.out.println(p2.equals(person));	// TRUE for scope="singleton" or DEAFULT else FALSE
    	System.out.println(person);
    	((ClassPathXmlApplicationContext)ctx).close();
    }
}
