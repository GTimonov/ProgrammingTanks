package com.mygdx.game.commands;

/**
 * Created by Goshan on 28.02.2017.
 */

public class CycleCommandsInvoker extends MovingCommandsInvoker {

    public CycleCommandsInvoker(int iteractionMount){
        this.iteractionMount = iteractionMount;
    }
    private int iteractionMount, currentIteraction = 1;

    public Boolean hasIteraction(){
        return  (currentIteraction < iteractionMount);
    }

    public void nextIteraction(){
        currentIteraction++;
        currentNum = 0;
    }

    @Override
    public void reset(){
        super.reset();
        currentIteraction =1;
    }
}
