package com.huseyinaydin.services;

import com.huseyinaydin.aspect.LoggingAspect;
import com.huseyinaydin.model.Circle;

public class ShapeServiceProxy extends ShapeService {

	@Override
	public Circle getCircle() {
		new LoggingAspect().loggingAdvice();
		return super.getCircle();
	}

}
