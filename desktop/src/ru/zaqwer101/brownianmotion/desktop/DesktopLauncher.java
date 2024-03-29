package ru.zaqwer101.brownianmotion.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import ru.zaqwer101.brownianmotion.BrownianMotion;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.fullscreen = true;
		config.height = 768;
		config.width = 1366;
		new LwjglApplication(new BrownianMotion(), config);
	}
}
