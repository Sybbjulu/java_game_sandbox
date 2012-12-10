package com.rhoward;

import static org.lwjgl.opengl.GL11.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Platformer {
	
	// window attributes
	private static final int WIDTH = 640;
	private static final int HEIGHT = 480;
	private static final String TITLE = "PLATFORMER";
	
	// timing 
	private static final int FPS = 60;
	private long lastFrame;
	
	private boolean isRunning = true;
	
	// -----------------------------------------
	
	public static void main(String[] args) {		
		Platformer pl = new Platformer(640, 480);		
	}	
	
	public Platformer(int width, int height) {
		
		initDisplay();
		initOpenGL();
		initEntities();
		initTimer();
		
		while (isRunning) {
			render();
			logic(getDelta());
			input();
			Display.update();
			Display.sync(FPS);
			
			if (Display.isCloseRequested()) { isRunning = false; }
		}
		
		Display.destroy();
	}
	
	private static long getTime() {
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private int getDelta() {
		long currentTime = getTime();
        int delta = (int) (currentTime - lastFrame);
        lastFrame = getTime();
        return delta;
	}
	
	private void initDisplay() {
		try {
			Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
			Display.setTitle(TITLE);
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
		}
	}
	
	private void initEntities() {		
		
	}
	
	private void initTimer() {
		lastFrame = getTime();
	}
	
	private void render() {		
		
	}
	
	private void logic(int delta) {		
		
	}
	
	private void input() {		
		
	}
	
	private void initOpenGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}	
}
