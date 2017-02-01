package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Goshan on 31.01.2017.
 *
 */

public abstract class MainActor extends Actor {


    protected Texture texture;

    private Vector2 cellXY;

    /**
    *  не созадавать
    * */
    public MainActor (){
        texture = createTexture();
        cellXY = new Vector2();
        setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
    }


    ///////////////////////////////////////////////////////////////////////////
    // overriden
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void draw(Batch batch, float alpha){

        batch.draw(texture, getX(),getY());
    }

    ///////////////////////////////////////////////////////////////////////////
    // abstract methods
    ///////////////////////////////////////////////////////////////////////////
    protected Texture createTexture(){
        return null;
    }


    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    /**
    *
    * */
    public void setCellXY(int x , int y){

        cellXY.x = x;
        cellXY.y = y;

        setY(cellXY.x);
        setX(cellXY.y);
    }

    public float getCellX(){
        return cellXY.x;
    }
    public float getCellY(){
        return cellXY.y;
    }
}
