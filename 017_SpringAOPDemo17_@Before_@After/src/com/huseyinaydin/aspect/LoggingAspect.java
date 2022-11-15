package com.huseyinaydin.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String getName())")
	public void loggingAdvice() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}
	
	@After("execution(public String getName())")
	public void loggingAdvice2() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan sonra çalýþtý.");
	}
}
