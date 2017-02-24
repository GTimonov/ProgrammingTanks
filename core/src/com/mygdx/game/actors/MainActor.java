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

    protected Vector2 currentCell;


    public MainActor (){
        texture = createTexture();
        currentCell = new Vector2();
        setBounds(getX(),getY(),getWidth(),getHeight());
        setOrigin(getWidth()/2, getHeight()/2);
    }

    ///////////////////////////////////////////////////////////////////////////
    // override
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void draw(Batch batch, float alpha){

        if (!Settings.IS_DEBUG)
            batch.draw(texture, getX(),getY());
    }

    ///////////////////////////////////////////////////////////////////////////
    // abstract methods
    ///////////////////////////////////////////////////////////////////////////
    protected abstract Texture createTexture();

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////



    public void positionItemByCell(int x , int y){
        currentCell.x = x;
        currentCell.y = y;
        setPosition(getCartesianXbyCell(x), getCartesianYbyCell(y));
    }

    public Vector2 getCurrentCell(){
        return currentCell;
    }

    ///////////////////////////////////////////////////////////////////////////
    // private
    ///////////////////////////////////////////////////////////////////////////

    protected float getCartesianXbyCell(float x){
        return x * Settings.CELL_SIZE + Settings.CELL_SIZE/2 - getOriginX();
    }
    protected float getCartesianYbyCell(float y){
        return y * Settings.CELL_SIZE + Settings.CELL_SIZE/2 - getOriginY();
    }

}
