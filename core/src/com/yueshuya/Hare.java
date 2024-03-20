package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Hare extends Animal{
    private Texture restImage;
    private boolean moving = true;
    private long minRestTime = 1000;
    private long rangeRestTime = 2000;
    private long restTimeOver = 0;


    public Hare(float y, float speed, String name) {
        super(y, speed, name);
        setSpeed((getSpeed() * 5) + (float) (-0.5 + Math.random()));
        setImage(new Texture("Hare moving.png"));
        restImage = new Texture("Hare sleeping.png");
    }

    @Override
    public void act(float v) {
        if (System.currentTimeMillis() > restTimeOver){
        if (Math.random() >= 0.02){
            super.act(v);
            moving = true;
        }else {
            //not acting
            moving = false;
            restTimeOver = System.currentTimeMillis() + ((long) (minRestTime + Math.random() * rangeRestTime));
        }
        }

    }
    //Turtle speed boost checker
    public boolean isMoving() {
        return moving;
    }


    @Override
    public void draw(SpriteBatch spriteBatch) {
        if(moving){
            super.draw(spriteBatch);
        }
        else {
            spriteBatch.draw(restImage, getX(), getY(), 50 ,50);
        }
    }

}
