package com.huseyinaydin.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {
	
	@Before("execution(public String com.huseyinaydin.model.Circle.getName())")
	public void loggingAdvice() {
		System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}
	
	/*@Before("execution(public * get*())")
	public void loggingAdvice() {
		System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}*/
	
	/*@Before("execution(* get*(..))")
	public void loggingAdvice() {
		System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}*/
	
	/*@Before("execution(* com.huseyinaydin.model.*.get*(..))")
	public void loggingAdvice() {
		System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}*/
	
	@After("execution(public String com.huseyinaydin.model.Circle.getName())")
	public void loggingAdvice2() {
		System.out.println("advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan sonra �al��t�.");
	}
	
	@Before("execution(public * get*())")
	public void secondAdvice() {
		System.out.println("second advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}
	
	@Before("allGetters() && allCircleMethods()")
	public void treeAdvice() {
		System.out.println("tree advice metodu �al��t�! get metodu �a�r�ld�. bu metot get metodundan �nce �al��t�.");
	}
	
	@Pointcut("execution(public * get*())")
	public void allGetters() {
		
	}
	
	@Pointcut("within(com.huseyinaydin.model.Circle)")
	public void allCircleMethods() {
		System.out.println("B�t�n circle metotlar� �al��t�!");
	}
	
	/*@Pointcut("within(com.huseyinaydin.model.*)")
	public void allModelMethods() {
		System.out.println("B�t�n circle metotlar� �al��t�!");
	}*/
}
