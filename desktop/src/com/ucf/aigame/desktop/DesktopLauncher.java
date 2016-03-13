package com.ucf.aigame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.ucf.aigame.GameMain;

public class DesktopLauncher {
	public static void main (String[] arg)
	{
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Assignment2";
		config.width = 1536;
		config.height = 768;
		new LwjglApplication(new GameMain(), config);
	}
}
