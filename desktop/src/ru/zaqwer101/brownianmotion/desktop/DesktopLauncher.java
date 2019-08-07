package ru.zaqwer101.brownianmotion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.zaqwer101.brownianmotion.BrownianMotion;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = false;
		config.height = 600;
		config.width = 800;
		new LwjglApplication(new BrownianMotion(), config);
	}
}
