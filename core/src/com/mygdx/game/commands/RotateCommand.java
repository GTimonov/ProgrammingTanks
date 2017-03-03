package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public class RotateCommand implements ICommand {

    private int degrees ;


    public RotateCommand(int degrees){
        this.degrees = degrees;
    }


    public void executeOn(RunningActor actor){
        actor.rotate(degrees);
    }

    public Array<ICommand> getCommandsIncluded(){
        Array<ICommand> array = new Array<ICommand>();
        array.add(this);
        return array;
    }
    public Boolean executable(){
        return true;
    }
    public int getIterationsLength(){
        return 1;
    }



}
