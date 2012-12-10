package com.rhoward;

import static org.lwjgl.opengl.GL11.*;

class EntityBox extends AbstractMoveableEntity {
	
	public EntityBox(double x, double y, double width, double height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw() {
		glRectd(x, y, x + width, y + height);
	}
}