package ru.zaqwer101.brownianmotion;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

import java.util.Random;

public class BMObject {
    private Vector2 position;
    private Vector2 velocity;

    public Color color;
    public int radius;
    private static int _id = 0;
    int id;

    public BMObject(Color color, int radius, int x, int y) {
        position = new Vector2(x, y);
        this.color = color;
        this.radius = radius;
        id = _id++;
        velocity = new Vector2(1, 1);
        velocity.rotate(new Random().nextInt(360));
    }

    public float[] getCoordinates() {
        return new float[]{this.position.x, this.position.y};
    }

    public void move(int maxx, int maxy) {
        if ((this.position.x > (maxx - radius)) || (this.position.x + velocity.x < radius)) {
            velocity.x = velocity.x * -1;

            // нормализуем позиции, чтобы не уходило в цикл :/
            if (position.x < radius)
                position.x = radius + 1;
            if (position.x > maxx)
                position.x = maxx - 1;
        }

        if ((this.position.y > (maxy - radius)) || (this.position.y + velocity.y < radius)) {
            velocity.y = velocity.y * -1;

            if (position.y < radius)
                position.y = radius + 1;
            if (position.y > maxy)
                position.y = maxy - 1;
        }

        position = position.sub(velocity);
    }
}
