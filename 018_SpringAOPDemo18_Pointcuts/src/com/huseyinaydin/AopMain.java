package com.huseyinaydin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huseyinaydin.services.ShapeService;

public class AopMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		ShapeService shapeService = applicationContext.getBean("shapeService",ShapeService.class);
		System.out.println(shapeService.getCircle().getName());
	}

}
