package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 23.02.2017.
 */

public class CycleCommand implements ICommand {


    private Array<ICommand> comnandsIncluded;
    private int iterationsLength;

    public CycleCommand(Array<ICommand> comnandsIncluded, int iterationsLength) {

        this.comnandsIncluded = comnandsIncluded;
        this.iterationsLength = iterationsLength;
    }
    public void executeOn(RunningActor actor){

    }
    public Boolean executable(){
        return false;
    }

    public Array<ICommand> getCommandsIncluded(){
        return comnandsIncluded;
    }
    public int getIterationsLength(){
        return iterationsLength;
    }
}
