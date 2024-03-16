package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;

public class Kangaroo extends Animal{
    private float mutation = (float) (-1.5 + Math.random()*2);
    public Kangaroo(float y, float speed) {
        super(y, speed);
        setSpeed((getSpeed() * 3f) + mutation);
        setImage(new Texture("Kangaroo.png"));
    }
    @Override
    public void act(float delta) {
        x += speed;
        y += (float) (5 * Math.sin(0.1 * x));
    }

}
