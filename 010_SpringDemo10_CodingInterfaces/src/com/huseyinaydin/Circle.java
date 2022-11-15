package com.huseyinaydin;

public class Circle implements Shape {

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
