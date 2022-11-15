package com.huseyinaydin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	/*@After("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("geriye string dönderen methoddan önce çalýþtý! parametre: " + name);
	}*/
	
	@AfterReturning(pointcut = "args(name)",returning = "returnString") //circle set metodu geriye string dönderdikten sonra çalýþýr
	public void stringArgumentMethods(String name,String returnString) {
		System.out.println("geriye string dönderen metoddan sonra çalýþtý! parametre: " + name +" geriye dönderilen : " + returnString);
	}
	
	@AfterThrowing(pointcut = "args(name)",throwing = "ex")//istisna fýrlatýldýktan sonra bu metot çalýþýr
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("ardýndan istisna fýrlatýldý! " + ex);
	}
	
	@Before("execution(public * get*())")
	public void allGetters() {
		//System.out.println("advice metodu çalýþtý! get metodu çaðrýldý. bu metot get metodundan önce çalýþtý.");
	}
	
	
	@Pointcut("within(com.huseyinaydin.model.Circle)")
	public void allCircleMethods() {
		//System.out.println("Bütün circle metotlarý çalýþtý!");
	}
	
}
