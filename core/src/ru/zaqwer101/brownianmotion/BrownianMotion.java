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

public class BrownianMotion extends ApplicationAdapter {
    GL20 gl;
    ShapeRenderer renderer;
    private Thread fps;
    private int fpsCounter;

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
        startFpsCounter();
        gl = Gdx.graphics.getGL20();
        renderer = new ShapeRenderer();
    }

    private void draw(ShapeRenderer renderer) {
        renderer.circle(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2, 100);
		fpsCounter++;
    }

    @Override
    public void render() {
        gl.glClearColor(0, 0, 0, 0);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.setColor(Color.RED);
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        draw(renderer);
        renderer.end();
    }
}
