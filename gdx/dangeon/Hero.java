package ru.geekbrains.dungeon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Hero {
    private ProjectileController projectileController;
    private Vector2 position;
    private Vector2 velocity;
    private int speed=100;
    private TextureRegion texture;
    private int shootMode=1;
    private int a = 180;

    public Hero(TextureAtlas atlas, ProjectileController projectileController) {
        this.position = new Vector2(100, 100);
        this.velocity = new Vector2(0, 0);
        this.texture = atlas.findRegion("tank");
        this.projectileController = projectileController;
    }

    public void update(float dt) {

        if (Gdx.input.isKeyJustPressed(Input.Keys.Q)) {
            shootMode = (int) MathUtils.cosDeg(a);
            a = a + 180;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            if (shootMode == 1) {
                projectileController.activate(position.x, position.y, 200, 0);
            } else {
                projectileController.activate(position.x, position.y, 200, 20);
                projectileController.activate(position.x, position.y, 200, -20);
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)){
            velocity.set(speed,0);
            position.mulAdd(velocity,dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)){
            velocity.set(-speed,0);
            position.mulAdd(velocity,dt);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)){

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)){
            velocity.set(speed,-speed);
            position.mulAdd(velocity,dt);
        }
    }
    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x - 20, position.y - 20);
    }
}
