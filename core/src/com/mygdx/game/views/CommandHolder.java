package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.mygdx.game.utils.FontsFactory;

/**
 * Created by Goshan on 02.03.2017.
 */

public class CommandHolder extends Group {

    public java.lang.String num;
    private Label lbl;

    public CommandHolder(java.lang.String num){
        super();
        this.num = num;
        setBounds(getX(),getY(),getWidth(),getHeight());
        addLabel(num);
    }

    @Override
    public void setSize (float width, float height) {
        super.setSize(width, height);
        updatePosistion();
    }
    @Override
    protected void drawDebugChildren(ShapeRenderer shapes) {

    }
    @Override
    public Actor hit (float x, float y, boolean touchable) {
        return x >= 0 && x < getWidth() && y >= 0 && y < getHeight() ? this : null;
    }

    private void addLabel(java.lang.String num){
        BitmapFont font = FontsFactory.getElectrobyteFont(16);
        Label.LabelStyle style = new Label.LabelStyle(font, Color.GOLD);
        lbl = new Label(num, style);
        lbl.setDebug(false);
        lbl.setPosition(getWidth()/2, getHeight()/2);
        addActor(lbl);
    }
    private void updatePosistion(){
        setBounds(getX(),getY(),getWidth(),getHeight());
        lbl.setPosition(getWidth()/2-lbl.getWidth()/2, getHeight()/2-lbl.getHeight()/2);
    }

    public Actor getChildCommand(){
        return null;
    }

    public void setChildCommand(Actor actor){

    }

}
