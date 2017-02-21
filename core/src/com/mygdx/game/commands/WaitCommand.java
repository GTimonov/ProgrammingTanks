package com.mygdx.game.commands;

import com.mygdx.game.actors.RunningActor;

/**
 * Created by George on 18.02.2017.
 */

public class WaitCommand implements ICommand {

    private int times;

    public WaitCommand(RunningActor actor, int times) {
        this.times = times;

    }
    public void executeOn(RunningActor actor){

    }

}
