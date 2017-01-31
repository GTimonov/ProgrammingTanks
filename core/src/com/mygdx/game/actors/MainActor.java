package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Goshan on 31.01.2017.
 */

public abstract class MainActor extends Actor {

    private Texture texture;

    public MainActor (){
        texture = getTexture();
        setBounds(getX(),getY(),texture.getWidth(),texture.getHeight());
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture, getX(),getY());
    }

    protected Texture getTexture(){
        return null;
    }
}
