package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;

public class Gecko extends Animal{
    public Gecko(float y, float speed) {
        super(y, speed);
        setSpeed((getSpeed() * 3.2f) + (float) (-0.5 + Math.random()));
        setImage(new Texture("Gecko.png"));

    }
}
