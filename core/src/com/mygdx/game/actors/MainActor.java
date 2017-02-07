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

    //public void setPositionByCell

    public void positionItemByCell(int x , int y){
        setX(x * Settings.CELL_SIZE + Settings.CELL_SIZE/2 - getWidth()/2);
        setY(y * Settings.CELL_SIZE + Settings.CELL_SIZE/2 - getHeight()/2);
    }
}
