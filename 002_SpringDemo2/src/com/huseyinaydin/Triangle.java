package com.huseyinaydin;

import java.util.List;

public class Triangle {
	private List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public void draw() {
		points.forEach(point->{
			System.out.println("Point " + point.getX() + ", " + point.getY());
		});
	}
	
}
