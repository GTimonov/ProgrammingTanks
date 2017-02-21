package com.mygdx.game.commands;

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

        int tankRotation = (int)actor.getRotation();


        actor.rotate(degrees + tankRotation);
    }




}
