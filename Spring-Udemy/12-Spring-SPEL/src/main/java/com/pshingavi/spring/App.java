package com.pshingavi.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx = new FileSystemXmlApplicationContext("spring.xml");
        Robot robot = ctx.getBean("robot", Robot.class);
        robot.speak();
    }
}
