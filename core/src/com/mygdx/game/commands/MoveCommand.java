package com.mygdx.game.commands;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand extends BasicCommand {

    private int toX;
    private int toY;

    public MoveCommand(RunningActor actor, int toX, int toY) {
        super(actor);
        this.toX = toX;
        this.toY = toY;
    }


    @Override
    protected Action getAction(){
        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition((runningActor.getCellX() + toX) * Settings.CELL_SIZE, (runningActor.getCellY() + toY) * Settings.CELL_SIZE);
        moveAction.setDuration(1f);
        return moveAction;
    }

    protected void updateActorModel(){
        runningActor.setCellXY(toX, toY);
    }

}