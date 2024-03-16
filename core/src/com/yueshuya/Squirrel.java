package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;

public class Squirrel extends Animal{
    public Squirrel(float y, float speed) {
        super(y, speed);
        setSpeed((getSpeed() * 4f) + (float) (-0.5 + Math.random()));
        setImage(new Texture("Inheritance Animal Sim Squirrel.png"));
    }


}
