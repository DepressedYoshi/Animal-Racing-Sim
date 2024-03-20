package com.yueshuya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;

public class GamePlayScreen implements Screen {
    public static final float WORLD_WIDTH = 1024;
    public static final float WORLD_HEIGHT = 768;
    public static final int FINISH_LINE = 900;


    //Object that allows us to draw all our graphics
    private SpriteBatch spriteBatch;
    //object tha allows us to draw shapes
    private ShapeRenderer shapeRenderer;
    //camera to view out world
    private Camera camera;
    //control POV - zoom in and out, or lock their view
    private Viewport viewport;

    private ArrayList<Animal> animals = new ArrayList<>();
    private BitmapFont deafaultfont = new BitmapFont();
    private long startTime;
    private boolean winner = false;
    private long winnerTime;
    private String winnerName;
    private boolean racing = false;


    //this runs one time at teh very beginning
    //all set up should happen here like a constructor
    @Override
    public void show() {
        this.camera = new OrthographicCamera();//2D camera
        camera.position.set(WORLD_WIDTH/2, WORLD_HEIGHT/2,0);
        camera.update();
        //freeze my view to 1024 by 768  no mater the window size
        viewport = new FitViewport(WORLD_WIDTH, WORLD_HEIGHT, camera);
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        //??? black magic dont touch - some problme McElrea dont know
        shapeRenderer.setAutoShapeType(true);
        createAnimals();
        startTime = System.currentTimeMillis();
    }

    private void createAnimals() {
        Hare hare = new Hare(650, 1, "Adam the Hare");
        animals.add(hare);
        animals.add(new Turtle(550, 1, hare, "Bob The turtle"));
        animals.add(new Elephant(450, 1,"Calvin the elephant"));
        animals.add(new Kangaroo(350, 1,"David the Kangaroo"));
        animals.add(new Rat(250, 1,"Elvis the rat"));
    }

    public void clearScreen(){
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }

    public void drawGUI(){
        long raceTime = System.currentTimeMillis() - startTime;
        long secconds = raceTime / 1000;
        long tenth = raceTime / 100  % 10 ;
        deafaultfont.draw(spriteBatch, "TIME: " + secconds + "." + tenth, WORLD_WIDTH/2, WORLD_HEIGHT - 5);

        //when win
        if (winner){
             secconds = (winnerTime - startTime)/ 1000;
             tenth = (winnerTime - startTime) / 100  % 10 ;
            deafaultfont.draw(spriteBatch, "WINNING TIME: " + secconds + "." + tenth, WORLD_WIDTH/2, WORLD_HEIGHT - 50);
            deafaultfont.draw(spriteBatch, "Congrats" + winnerName, WORLD_WIDTH/2, WORLD_HEIGHT - 350);

        }
    }

    public void raceAnimals(float v){
        for(Animal a : animals){
            if (!a.isFinish()){
                a.act(v);
            }else { //some finish
                if(!winner){//are they the first shin
                    winner = true;
                    winnerTime = System.currentTimeMillis();
                    winnerName = a.getName();
                }
            }
        }
    }
    //this method runs at FPS speed, repeatedly looping
    @Override
    public void render(float v) {
        //all AI Code goes here
        clearScreen();
        raceAnimals(v);
        //all shape drawing mus happen here
        shapeRenderer.begin();
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.GOLD);
        shapeRenderer.rect(FINISH_LINE, 0,50,WORLD_HEIGHT);
        shapeRenderer.end();
        // all graphic drawing must happen here
        spriteBatch.begin();
        //darw all the tils here//
        for(Animal a : animals){
            a.draw(spriteBatch);
        }
        drawGUI();
        spriteBatch.end();

    }

    @Override
    public void resize(int i, int i1) {
        viewport.update(i,i1);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        shapeRenderer.dispose();
        spriteBatch.dispose();
    }
}
