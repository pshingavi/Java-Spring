package com.expedia.pshingavi;

import com.expedia.pshingavi.dao.JdbcDaoImpl;
import com.expedia.pshingavi.model.Circle;

public class JDBCDemo {

	public static void main(String[] args) {
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());
	}

}
