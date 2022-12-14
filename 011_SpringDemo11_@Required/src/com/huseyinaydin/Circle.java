package com.huseyinaydin;

import org.springframework.beans.factory.annotation.Required;

public class Circle implements Shape {

	private Point center;
	
	@Override
	public void draw() {
		System.out.println("Circle drawing");
		System.out.println("Dairenin orta noktas? " + center.getX() + " - " + center.getY());
	}

	public Point getCenter() {
		return center;
	}

	@Required
	public void setCenter(Point center) {
		this.center = center;
	}
	
}
