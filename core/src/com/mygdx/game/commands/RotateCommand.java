package com.mygdx.game.commands;

import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public class RotateCommand implements ICommand {

    private int degrees ;
    private RunningActor runningActor;

    public RotateCommand(RunningActor actor, int degrees){
        runningActor = actor;
        this.degrees = degrees;
    }


    public void execute(){
        runningActor.rotate(degrees);
    }




}
