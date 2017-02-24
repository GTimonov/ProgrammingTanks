package com.mygdx.game.commands;

import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand implements ICommand{


    public MoveCommand() {

    }
    public void executeOn(RunningActor actor){
        actor.move();
    }
}