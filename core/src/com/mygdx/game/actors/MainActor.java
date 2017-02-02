package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 31.01.2017.
 *
 */

public abstract class MainActor extends Actor {


    protected Texture texture;

    private Vector2 cellXY;

    private int cellRotation;

    public MainActor (){
        texture = createTexture();
        cellXY = new Vector2();
        setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
    }

    ///////////////////////////////////////////////////////////////////////////
    // override
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void draw(Batch batch, float alpha){

        batch.draw(texture, getX(),getY());
    }

    ///////////////////////////////////////////////////////////////////////////
    // abstract methods
    ///////////////////////////////////////////////////////////////////////////
    protected abstract Texture createTexture();

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    public void setCellXY(int x , int y){
        cellXY.x = x;
        cellXY.y = y;
    }

    public float getCellX(){
        return cellXY.x;
    }
    public float getCellY(){
        return cellXY.y;
    }

    public void setCellAngle(int angle){
        cellRotation = angle;
    }
    public int getCellAngle(){
        return cellRotation;
    }

    public void positionByOwnValues() {
        setY(cellXY.x * Settings.CELL_SIZE);
        setX(cellXY.y * Settings.CELL_SIZE);
        setRotation(cellRotation);
    }

}
