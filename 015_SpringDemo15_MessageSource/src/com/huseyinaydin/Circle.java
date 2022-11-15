package com.huseyinaydin;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Shape {

	@Resource(name = "onePoint") //Autowired'in görevini görüyor. buna jsr-250 deniyor
	private Point center;
	
	@Autowired
	private MessageSource messageSource; 
	
	@Override
	public void draw() {
		System.out.println(this.messageSource.getMessage("drawing.circle", null, "Default Drawing Message", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {this.getCenter().getX(),this.getCenter().getY()}, "Default Point Message", null));
		//System.out.println("Dairenin orta noktasý " + center.getX() + " - " + center.getY());
		String s = this.messageSource.getMessage("greeting", null, "Default Greeting", null);
		System.out.println(s);
	}

	public Point getCenter() {
		return center;
	}

	
	public void setCenter(Point center) {
		this.center = center;
	}
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@PostConstruct
	public void initCircle() {
		System.out.println("Circle hazýrlandý");
	}
	
	@PreDestroy
	public void destroyCircle() {
		System.out.println("Circle bitirildi");
	}
	
}
