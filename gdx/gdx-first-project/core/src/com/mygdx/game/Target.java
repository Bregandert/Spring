package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Target {
    private Texture texture;
    private float x;
    private float y;


    public Target(float x,float y) {
        this.texture = new Texture("block.png");
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x , y );
    }

    public void dispose() {
        texture.dispose();
    }
}

