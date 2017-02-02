package com.mygdx.game.commands;

import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public abstract class BasicCommand implements ICommand {

    protected RunningActor runningActor;
    protected Boolean isRunning = false;

    public BasicCommand (RunningActor actor) {
        runningActor = actor;
    }

    ///////////////////////////////////////////////////////////////////////////
    // abstract methods
    ///////////////////////////////////////////////////////////////////////////

    protected abstract Action getAction();
    protected abstract void updateActorModel();


    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    public Boolean getIsRunning(){
        return isRunning;
    }

    public void execute(){
        isRunning = true;
        runningActor.addAction(new SequenceAction(getAction(), new Action() {
            @Override
            public boolean act(float delta) {
                updateActorModel();
                isRunning = false;
                return true;
            }
        }));
    }


}
