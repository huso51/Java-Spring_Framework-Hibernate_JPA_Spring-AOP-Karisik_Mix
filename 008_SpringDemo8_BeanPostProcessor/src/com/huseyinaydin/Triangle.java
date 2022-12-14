package com.huseyinaydin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements InitializingBean,DisposableBean {
	@Autowired
	@Qualifier("pointA")
	private Point pointA;
	
	@Autowired
	@Qualifier("pointB")
	private Point pointB;
	
	@Autowired
	@Qualifier("pointC")
	private Point pointC;
	
	private ApplicationContext applicationContext = null;

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}
	
	public void draw() {
		System.out.println("Point A " + pointA.getX() + ", " + pointA.getY());
		System.out.println("Point B " + pointB.getX() + ", " + pointB.getY());
		System.out.println("Point C " + pointC.getX() + ", " + pointC.getY());
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Triangle bean oluşturuldu init metodu çalıştırıldı!");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("Triangle bean yok edildi destroy metodu çalıştırıldı!");
	}
	
	public void myInit() {
		System.out.println("Triangle bean oluşturuldu init metodu çalıştırıldı!");
	}
	
	public void myDestroy(){
		System.out.println("Triangle bean yok edildi destroy metodu çalıştırıldı!");
	}
	
}
