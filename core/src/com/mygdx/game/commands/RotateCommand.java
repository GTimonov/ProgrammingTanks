package com.mygdx.game.commands;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public class RotateCommand extends BasicCommand {

    private int degrees ;

    public RotateCommand(RunningActor actor, int degrees){
        super(actor);
        this.degrees = degrees;
    }

    @Override
    protected Action getAction(){
        RotateToAction rotateAction = new RotateToAction();
        rotateAction.setRotation(runningActor.getRotation() + degrees);
        rotateAction.setDuration(1f);
        return rotateAction;
    }

    protected void updateActorModel(){
        runningActor.setCellAngle(runningActor.getCellAngle() + degrees);
    }




}
