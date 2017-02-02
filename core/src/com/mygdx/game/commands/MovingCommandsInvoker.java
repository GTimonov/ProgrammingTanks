package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MovingCommandsInvoker {

    private Array <ICommand> commandsStack = new Array<ICommand>();
    private Boolean isStarted = false;
    private Boolean isBuisy = false;
    private Iterator <ICommand> iterator;
    private ICommand currentCommand;


    public void addCommand(ICommand command){
        commandsStack.add(command);
    }

    public void startCommands(){
        isStarted = true;
        iterator = commandsStack.iterator();
    }

    public void act (float delta) {
        if (!isStarted)
            return;
        if (currentCommand == null || !currentCommand.getIsRunning()) {
            if (iterator.hasNext()) {
                currentCommand = iterator.next();
                currentCommand.execute();
            }
            else{
                currentCommand = null;
                isStarted = false;
            }
        }

    }


}
