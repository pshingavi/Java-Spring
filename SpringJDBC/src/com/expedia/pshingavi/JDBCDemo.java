package com.expedia.pshingavi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expedia.pshingavi.dao.JdbcDaoImpl;

public class JDBCDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		//System.out.println(dao.getCircle(1).getName());
		//System.out.println(dao.getCircleCount());
		//System.out.println(dao.getCircleName(1));
		//System.out.println(dao.getCircleForId(1).getName());
		System.out.println(dao.getAllCircles().size());	// List<Circle>
	}

}
