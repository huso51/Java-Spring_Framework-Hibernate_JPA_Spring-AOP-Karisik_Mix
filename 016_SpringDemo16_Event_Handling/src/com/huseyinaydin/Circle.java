package com.huseyinaydin;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape,ApplicationEventPublisherAware {

	@Resource(name = "onePoint") //Autowired'in görevini görüyor. buna jsr-250 deniyor
	private Point center;
	
	private ApplicationEventPublisher publisher;
	
	@Override
	public void draw() {
		System.out.println("Circle drawing");
		System.out.println("Dairenin orta noktasý " + center.getX() + " - " + center.getY());
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
	}

	public Point getCenter() {
		return center;
	}

	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void initCircle() {
		System.out.println("Circle hazýrlandý");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Circle bitirildi");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
}
