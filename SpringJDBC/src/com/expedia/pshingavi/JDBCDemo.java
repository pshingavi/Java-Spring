package com.expedia.pshingavi;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.expedia.pshingavi.dao.HibernateDaoImpl;

public class JDBCDemo {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//NamedJdbcDaoImpl dao = ctx.getBean("namedJdbcDaoImpl", NamedJdbcDaoImpl.class);
		//System.out.println(dao.getCircleNameForId(4));	//Fourth circle
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		System.out.println(dao.getCircleCount());
	}

}
