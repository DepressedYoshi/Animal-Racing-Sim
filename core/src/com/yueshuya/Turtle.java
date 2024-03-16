package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;

public class Turtle extends Animal{
    private Hare hare;
    public Turtle(float y, float speed, Hare hare) {
        super(y, speed);
        setSpeed((getSpeed() * 0.85f) + (float) (-0.5 + Math.random()));
        setImage(new Texture("Turtle.png"));
        this.hare = hare;
    }

    @Override
    public void act(float v) {
        if (hare != null && !hare.isMoving()) {
            x += (speed * 4);
        } else {
            super.act(v);
        }
    }
}
