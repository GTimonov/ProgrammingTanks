package com.mygdx.game.commands;

import com.mygdx.game.actors.RunningActor;

/**
 * Created by George on 18.02.2017.
 */

public class WaitCommand implements ICommand {



    public WaitCommand() {


    }
    public void executeOn(RunningActor actor){
        actor.waitStep();
    }

}
