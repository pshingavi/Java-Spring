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
        Market market = ctx.getBean("market", Market.class);
        System.out.println(market);
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
