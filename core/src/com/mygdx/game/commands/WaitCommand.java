package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by George on 18.02.2017.
 */

public class WaitCommand implements ICommand {


    private int cells;
    public WaitCommand(int cells) {
        this.cells = cells;
    }
    public WaitCommand() {
        this.cells = 1;
    }

    public void executeOn(RunningActor actor){
        actor.waitStep();
    }

    public Array<ICommand> getCommandsIncluded(){
        Array<ICommand> array = new Array<ICommand>();
        for (int i = 0; i < cells; i++)
            array.add(new WaitCommand());
        return array;
    }
    public Boolean executable(){
        return cells == 1;
    }
    public int getIterationsLength(){
        return 1;
    }


}
