package com.huseyinaydin.services;

import com.huseyinaydin.aspect.Loggable;
import com.huseyinaydin.model.Circle;
import com.huseyinaydin.model.Triangle;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	@Loggable
	public Circle getCircle() {
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public Triangle getTriangle() {
		return triangle;
	}
	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}
	
}
