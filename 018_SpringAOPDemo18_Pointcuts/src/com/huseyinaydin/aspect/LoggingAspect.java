package com.huseyinaydin.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String com.huseyinaydin.model.Circle.getName())")
	public void loggingAdvice() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}
	
	/*@Before("execution(public * get*())")
	public void loggingAdvice() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}*/
	
	/*@Before("execution(* get*(..))")
	public void loggingAdvice() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}*/
	
	/*@Before("execution(* com.huseyinaydin.model.*.get*(..))")
	public void loggingAdvice() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}*/
	
	@After("execution(public String com.huseyinaydin.model.Circle.getName())")
	public void loggingAdvice2() {
		System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan sonra çalýþtý.");
	}
	
	@Before("execution(public * get*())")
	public void secondAdvice() {
		System.out.println("second advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}
	
	@Before("allGetters() && allCircleMethods()")
	public void treeAdvice() {
		System.out.println("tree advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {
		
	}
	
	@Pointcut("within(com.huseyinaydin.model.Circle)")
	public void allCircleMethods() {
		System.out.println("Bütün circle metotlarý çalýþtý!");
	}
	
	/*@Pointcut("within(com.huseyinaydin.model.*)")
	public void allModelMethods() {
		System.out.println("Bütün circle metotlarý çalýþtý!");
	}*/
}
