package com.ecs.Jamkhed;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;


public class Main {
	public static void main(String[] args) {
		//create the listener that will receive the application events
		ApplicationListener listener = new Jamkhed();
		
		String title = "Jamkhed 0.02";
		int width=800, height=480;
		boolean useOpenGLES2 = false;
		
		//create the game
		new LwjglApplication(listener, title, width, height, useOpenGLES2);
	}
}
