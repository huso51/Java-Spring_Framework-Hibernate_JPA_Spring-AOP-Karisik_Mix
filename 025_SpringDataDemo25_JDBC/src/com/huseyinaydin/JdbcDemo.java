package com.huseyinaydin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huseyinaydin.dao.JdbcDaoImpl;
import com.huseyinaydin.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbcDaoImpl = applicationContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		Circle circle = jdbcDaoImpl.getCircle(1);
		System.out.println(circle.toString());
	}
}
