package com.mygdx.game.commands;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 23.02.2017.
 */

public class CycleCommand implements ICommand {


    private int comnandsLengdh, iterationsLength;

    public CycleCommand(int comnandsLengdh, int iterationsLength) {

        this.comnandsLengdh = comnandsLengdh;
        this.iterationsLength = iterationsLength;
    }
    public void executeOn(RunningActor actor){
        Gdx.app.error("Хуй", ", а не выполнение цикла");
    }
    public ICommand clone(){
        return null;
    }

    public int getCommandsLength(){
        return comnandsLengdh;
    }
    public int getIterationsLength(){
        return iterationsLength;
    }
}
