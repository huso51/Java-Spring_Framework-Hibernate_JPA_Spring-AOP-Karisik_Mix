package com.huseyinaydin.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("Circle set metodu �al��t�!");
		throw(new RuntimeException());
	}
	
	public String setNameandReturning(String name) {
		this.name = name;
		System.out.println("Circle set name and returning metodu �al��t�!");
		return name;
	}
}
