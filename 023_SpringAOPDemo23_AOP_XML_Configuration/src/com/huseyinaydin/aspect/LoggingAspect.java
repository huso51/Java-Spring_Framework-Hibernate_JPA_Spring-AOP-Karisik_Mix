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
			System.out.println("before advice proceed �ncesi");
			returnValue = proceedingJoinPoint.proceed();
			System.out.println("after advice proceed sonras�");
		} catch (Throwable e) {
			System.out.println("after throwing hata f�rlatman�n ard�ndan");
		}
		finally {
			System.out.println("after finnally ard�ndan final");
		}
		return returnValue;
	}
	
}
