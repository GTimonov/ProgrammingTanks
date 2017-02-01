package com.mygdx.game.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 01.02.2017.
 */

public abstract class RunningActor extends MainActor {

    public RunningActor() {
        super();
        sequenceActions = new SequenceAction();
    }



    private SequenceAction sequenceActions;

    private Boolean isRunning = false;

    public void addMoveAction(int x, int y){

        /*cellXY = new Vector2(x, y);
        cellXY.y+=y;*/
        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(x * Settings.CELL_SIZE, y * Settings.CELL_SIZE);
        moveAction.setDuration(1f);
        sequenceActions.addAction(moveAction);
    }

    public void addRotateAction(float degrees){

        RotateToAction rotateAction = new RotateToAction();
        rotateAction.setRotation(degrees);
        rotateAction.setDuration(1f);
        sequenceActions.addAction(rotateAction);

    }

    public void startActions(){

        if (isRunning) {
            Gdx.app.log("error", " is Moving now! ");
            return;
        }
        isRunning = true;
        sequenceActions.addAction( new Action() {
            @Override
            public boolean act(float delta) {
                isRunning = false;
                return true;
            }
        });
        addAction(sequenceActions);
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
                this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
                texture.getWidth(),texture.getHeight(),false,false);
    }


    @Override
    public void act(float delta){
        super.act(delta);
    }


}
