package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Animal {
    protected float x;
    protected float y;
    protected float speed;
    protected Texture image;

    public Animal(float y, float speed){
        this.x = 10;
        this.y = y;
        this.speed = speed;
        this.image = new Texture("Animal foot.png");
    }


    public void draw(SpriteBatch spriteBatch){
        spriteBatch.draw(this.image, this.x, this.y, 50,50);
    }

    public boolean isFinish(){
        return x >= 900;
    }

    public void act(float delta){
        x += speed;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getSpeed() {
        return speed;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setImage(Texture image) {
        this.image = image;
    }

    public Texture getImage() {
        return image;
    }
}
