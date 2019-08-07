package ru.zaqwer101.brownianmotion;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;

import java.util.Random;
import java.util.Vector;

public class BrownianMotion extends ApplicationAdapter {
    GL20 gl;
    ShapeRenderer renderer;
    private Thread fps;
    private int fpsCounter;
	BMObject object;
    Vector<BMObject> objects;

    Color[] colors = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };

	private void startFpsCounter() {
        fpsCounter = 0;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                while (true)
                    try {
                        Thread.sleep(1000);
                        System.out.println(fpsCounter);
                        fpsCounter = 0;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };
        fps = new Thread(task);
        fps.start();
    }

    @Override
    public void create() {
		gl = Gdx.graphics.getGL20();
		renderer = new ShapeRenderer();
        startFpsCounter();
		objects = new Vector<BMObject>();

        // create particles
		int step = (20 + 10) * 2; // радиус частицы + расстояние между ними
		for (int i=20; i <= Gdx.graphics.getHeight() - 20; i += step)
		{
			for (int j=20; j <= Gdx.graphics.getWidth() - 20; j += step)
			{
				objects.add(new BMObject(colors[new Random().nextInt(colors.length)], 20, j, i));
			}
		}
    }

    private void draw(ShapeRenderer renderer) {
		for (BMObject object : objects)
		{
		    object.move(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
			renderer.setColor(object.color);
			renderer.circle(object.getCoordinates()[0], object.getCoordinates()[1], object.radius);
		}
        fpsCounter++;
    }

    @Override
    public void render() {
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        draw(renderer);
        renderer.end();
    }
}
