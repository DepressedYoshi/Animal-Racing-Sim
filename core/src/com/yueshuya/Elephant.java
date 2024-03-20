package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;

public class Elephant extends Animal{

    public Elephant(float y, float speed, String name) {
        super(y, speed, name);
        setSpeed((getSpeed() * 1.5f) + (float) (-0.5 + Math.random()));
        setImage(new Texture("Elephant.png"));
    }

    @Override
    public void act(float delta) {
        super.act(delta);
    }
}
