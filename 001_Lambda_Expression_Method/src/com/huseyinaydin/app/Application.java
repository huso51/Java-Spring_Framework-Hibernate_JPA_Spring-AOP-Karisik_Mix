package com.huseyinaydin.app;

public class Application {
	public static void main(String[] args) {
		Uygula uygula = init();
		uygula.test("xx");
	}
	
	public static Uygula init() {
		return (args) ->{
			System.out.println(args);
		};
	}
}
