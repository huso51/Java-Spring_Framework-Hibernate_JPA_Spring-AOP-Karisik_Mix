package com.huseyinaydin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.huseyinaydin.dao.JdbcDaoImpl;
import com.huseyinaydin.dao.SimpleJdbcDaoImpl;
import com.huseyinaydin.model.Circle;

public class JdbcDemo {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
		JdbcDaoImpl jdbcDaoImpl = applicationContext.getBean("jdbcDaoImpl",JdbcDaoImpl.class);
		SimpleJdbcDaoImpl simpleJdbcDaoImpl = applicationContext.getBean("simpleJdbcDaoImpl",SimpleJdbcDaoImpl.class);
		/*Circle circle = jdbcDaoImpl.getCircle(1);
		System.out.println(circle.toString());*/
		
		jdbcDaoImpl.insertCircle(new Circle(2,"Second Circle"));
		System.out.println(jdbcDaoImpl.getCircleCount());
		System.out.println(jdbcDaoImpl.getCircleName(1));
		System.out.println(jdbcDaoImpl.getCircleForId(1));
		System.out.println(jdbcDaoImpl.getAllCircles());
		System.out.println(simpleJdbcDaoImpl.getCircleCount());
	}
}
