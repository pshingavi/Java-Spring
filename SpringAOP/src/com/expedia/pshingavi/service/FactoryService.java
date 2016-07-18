package com.expedia.pshingavi.service;

import com.expedia.pshingavi.model.Circle;
import com.expedia.pshingavi.model.Triangle;

public class FactoryService {

	public Object getBean(String beanType) {
		if(beanType.equals("shapeService")) return new ShapeServiceProxy();
		if(beanType.equals("circle")) return new Circle();
		if(beanType.equals("triangle")) return new Triangle();
		return null;
	}
}
