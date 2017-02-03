package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;


/**
 * Created by Goshan on 02.02.2017.
 */

public class MovingCommandsInvoker {

    private Array <ICommand> commandsStack = new Array<ICommand>();
    private ICommand currentCommand;


    public void addCommand(ICommand command){
        commandsStack.add(command);
    }

    public Boolean executeNext(){
        if (commandsStack.size != 0){
            currentCommand = commandsStack.removeIndex(0);
            currentCommand.execute();
        }
        else {
            return false;
        }
        return true;
    }



}
