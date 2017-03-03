package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand implements ICommand{

    private int cells;
    public MoveCommand() {
        this.cells = 1;
    }
    public MoveCommand(int cells) {
        this.cells = cells;
    }
    public void executeOn(RunningActor actor){
        actor.move();
    }

    public Array<ICommand> getCommandsIncluded(){
        Array<ICommand> array = new Array<ICommand>();
        for (int i = 0; i < cells; i++)
            array.add(new MoveCommand());
        return array;
    }
    public Boolean executable(){
        return cells == 1;
    }
    public int getIterationsLength(){
        return 1;
    }

}