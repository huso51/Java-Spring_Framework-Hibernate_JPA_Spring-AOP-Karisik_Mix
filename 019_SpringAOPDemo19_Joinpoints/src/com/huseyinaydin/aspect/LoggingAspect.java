package com.huseyinaydin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.huseyinaydin.model.Circle;

@Aspect
public class LoggingAspect {
	
	@Before("allCircleMethods()")
	public void loggingAdvice(JoinPoint joinPoint) {
		System.out.println(joinPoint.toString());
		Circle circle = (Circle) joinPoint.getTarget();
	}
	
	@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("geriye string d�nderen methoddan �nce �al��t�! parametre: " + name);
	}
	
	@Before("execution(public * get*())")
	public void allGetters() {
		//System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}
	
	
	@Pointcut("within(com.huseyinaydin.model.Circle)")
	public void allCircleMethods() {
		//System.out.println("B�t�n circle metotlar� �al��t�!");
	}
	
}
