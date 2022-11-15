package com.huseyinaydin.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.huseyinaydin.model.Circle;

public class LoggingAspect {
	
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnValue = null;
		try {
			System.out.println("before advice proceed öncesi");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("after advice proceed sonrasý");
		} catch (Throwable e) {
			System.out.println("after throwing hata fýrlatmanýn ardýndan");
		}
		finally {
			System.out.println("after finnally ardýndan final");
		}
		return returnValue;
	}
	
}
