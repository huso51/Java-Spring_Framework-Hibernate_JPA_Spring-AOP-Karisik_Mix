package com.huseyinaydin;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

	public static void main(String[] args) {
		//Triangle triangle = new Triangle();
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		applicationContext.registerShutdownHook();
		//Triangle triangle = (Triangle)beanFactory.getBean("triangle");
		Triangle triangle = (Triangle)applicationContext.getBean("triangle");
		triangle.draw();
	}

}
