package com.pshingavi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.pshingavi.spring.logger.LogWriter;
import com.pshingavi.spring.logger.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Logger logger = ctx.getBean("logger", Logger.class);
        logger.writeToConsole();
        logger.writeToFile();
        ((ClassPathXmlApplicationContext)ctx).close();
    }
}
