package com.expedia.pshingavi.service;

import com.expedia.pshingavi.aspect.LoggingAspect;
import com.expedia.pshingavi.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		// Can do some stuff here, like loggingAdvice call
		new LoggingAspect().loggingAdvice();
		// PRINTS : logging advice with proxy call
		return super.getCircle();
	}
}
