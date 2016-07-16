package com.expedia.pshingavi.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.expedia.pshingavi.springdemo.listener.DrawEvent;

@Component
/*
 * <bean class="...Circle" /> => Single bean definition. So Point class is not @Component
 * Also to enable spring to know this @component add <context:component-scan> in spring.xml
 * */
public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	@Autowired
	private MessageSource messageSource;	// Interface
	
	
	private ApplicationEventPublisher publisher;	// Set by implementing AppEPubAware.setAppEPubAware()

	public Point getCenter() {
		return center;
	}
	
	// In order to tell spring to handle NPE at init (BeanPostProcessor does this) and not wait till application fails
	@Autowired	// If Autowire fails to map type or name of bean handler passed to Qualifier
	@Qualifier("circleQualifier")	// See qualifier tag in pointA. This was not required if 
	public void setCenter(Point center) {
		this.center = center;
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "default draw for circle", null));
		/*System.out.println("Point : " + this.center.getX() + ", " + this.center.getY());*/
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {this.center.getX(), this.center.getY()}, "default draw for circle", null));
		System.out.println(this.messageSource.getMessage("greeting-circle", null, "Default circle", null));
		DrawEvent event = new DrawEvent(this);
		publisher.publishEvent(event);
	}

	@PostConstruct
	public void initCircle() {
		System.out.println("At circle post construct");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("At circle pre destroy");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}
}
