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

    public Boolean hasCommand(){
        return commandsStack.size > 0;
    }

    public void executeNext(){
        if (hasCommand()){
            currentCommand = commandsStack.removeIndex(0);
            currentCommand.execute();
        }
    }
}
