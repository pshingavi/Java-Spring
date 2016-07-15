package com.expedia.pshingavi.springdemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object beanObject, String nameOfBean) throws BeansException {
		System.out.println("In after bean init for : " + nameOfBean);
		return beanObject;
	}

	@Override
	public Object postProcessBeforeInitialization(Object beanObject, String nameOfBean) throws BeansException {
		System.out.println("In before bean init for : " + nameOfBean);
		return beanObject;
	}

}
