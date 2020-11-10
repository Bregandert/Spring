package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Tank {
    private Texture texture;
    private Texture textureWeapon;
    private float x;
    private float y;
    private float lastx;
    private float lasty;
    private float speed;
    private float angle;
    private float deltax;
    private float deltay;
    private float angleWeapon;
    private Projectile projectile;
//    private Target target;
    private float scale;

    public Tank() {
        this.texture = new Texture("tank.png");
        this.textureWeapon = new Texture("weapon.png");
        this.projectile = new Projectile();
//        this.target=new Target(250,300);
        this.x = 41.0f;
        this.y = 41.0f;
        this.speed = 240.0f;
        this.scale = 3.0f;
    }

    public void update(float dt) {
        deltax=speed * MathUtils.cosDeg(angle) * dt;
        deltay=speed * MathUtils.sinDeg(angle) * dt;
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            angle -= 90.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            angle += 90.0f * dt;
        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.D)) {
//            angle -= 90.0f;
//        }
//        if (Gdx.input.isKeyJustPressed(Input.Keys.A)) {
//            angle += 90.0f;
//        }

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            if (40<=(x+deltax)&(x+deltax)<=1220) {
                x += speed * MathUtils.cosDeg(angle) * dt;
            } else {
                x=x;
            }
            if (40<=(y+deltay)&(y+deltay)<=660) {
                y += speed * MathUtils.sinDeg(angle) * dt;
            }else{
                y = y;
                }
            }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            if (40<=(x-deltax)&(x-deltax)<=1220) {
               x -= speed * MathUtils.cosDeg(angle) * dt;
            } else {
                x=x;
            }
            if (40<=(y-deltay)&(y-deltay)<=660) {
                y -= speed * MathUtils.sinDeg(angle) * dt;
            }else{
                y =y;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.Q)) {
            angleWeapon -= 90.0f * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.E)) {
            angleWeapon += 90.0f * dt;
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE) && !projectile.isActive()) {
            projectile.shoot(x + 16 * scale * MathUtils.cosDeg(angle), y + 16* scale * MathUtils.sinDeg(angle), angle + angleWeapon);
        }
        if (projectile.isActive()) {
            projectile.update(dt);
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, x - 20, y - 20, 20, 20, 40, 40, scale, scale, angle, 0, 0, 40, 40, false, false);
        batch.draw(textureWeapon, x -20, y -20, 20, 20, 40, 40, scale, scale, angle + angleWeapon, 0, 0, 40, 40, false, false);
        if (projectile.isActive()) {
            projectile.render(batch);
        }
    }

    public void dispose() {
        texture.dispose();
        projectile.dispose();
    }
}
