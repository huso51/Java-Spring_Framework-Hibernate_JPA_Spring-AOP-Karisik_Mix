package com.huseyinaydin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Circle implements Shape {

	@Autowired
	@Qualifier(value = "circleRelated")
	private Point center;
	
	@Override
	public void draw() {
		System.out.println("Circle drawing");
		System.out.println("Dairenin orta noktasý " + center.getX() + " - " + center.getY());
	}

	public Point getCenter() {
		return center;
	}

	
	public void setCenter(Point center) {
		this.center = center;
	}
	
}
