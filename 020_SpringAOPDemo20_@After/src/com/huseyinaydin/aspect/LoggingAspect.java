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
		System.out.println("geriye string d�nderen methoddan �nce �al��t�! parametre: " + name);
	}*/
	
	@AfterReturning(pointcut = "args(name)",returning = "returnString") //circle set metodu geriye string d�nderdikten sonra �al���r
	public void stringArgumentMethods(String name,String returnString) {
		System.out.println("geriye string d�nderen metoddan sonra �al��t�! parametre: " + name +" geriye d�nderilen : " + returnString);
	}
	
	@AfterThrowing(pointcut = "args(name)",throwing = "ex")//istisna f�rlat�ld�ktan sonra bu metot �al���r
	public void exceptionAdvice(String name, RuntimeException ex) {
		System.out.println("ard�ndan istisna f�rlat�ld�! " + ex);
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
