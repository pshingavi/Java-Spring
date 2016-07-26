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
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        FruitBasket fruitBasket = ctx.getBean("fruitBasket", FruitBasket.class);
        System.out.println(fruitBasket);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
