package com.yueshuya;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Rat extends Animal {
    private long minRestTime = 500;
    private long maxRestTime = 2000;
    private long restEndTime = 0;
    private boolean isResting = false;

    public Rat(float y, float speed, String name) {
        super(y, speed, name);
        setSpeed((getSpeed() * 5) + (float) (-2f + Math.random()*3));
        setImage(new Texture("Animal Sim Rat.png"));
    }

    @Override
    public void act(float v) {
        long currentTime = System.currentTimeMillis();
        if (!isResting && Math.random() * x >= 800) {
            isResting = true;
            restEndTime = currentTime + minRestTime + (long) (Math.random() * (maxRestTime - minRestTime));
        }

        if (isResting) {
            if (currentTime >= restEndTime) {
                isResting = false;
            } else {
                x -= speed * 0.5;
                return;
            }
        }
        // call outside the if-else block to ensure it's called after resting ends or if the entity wasn't resting to begin with.
        super.act(v);
        // Clamp x to a minimum of 10 to avoid moving behind the starting line
        if (x < 10) {
            x = 10;
        }

    }

    @Override
    public void draw(SpriteBatch spriteBatch) {
        float width = 50;
        float height = 50;
        if (isResting) {
            spriteBatch.draw(getImage(), this.x + width, this.y, -width, height);
        } else {
            spriteBatch.draw(getImage(), this.x, this.y, width, height);
        }
    }
}

