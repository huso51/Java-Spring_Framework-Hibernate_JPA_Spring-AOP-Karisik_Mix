package com.huseyinaydin;

import org.springframework.context.ApplicationEvent;

public class DrawEvent extends ApplicationEvent {

	public DrawEvent(Object source) {
		super(source);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Draw olay� ger�ekle�ti!";
	}

}
