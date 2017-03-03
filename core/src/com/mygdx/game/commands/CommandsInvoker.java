package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;


/**
 * Created by Goshan on 02.02.2017.
 */

public class CommandsInvoker {

    public CommandsInvoker(int iteractionMount){
        this.iteractionMount = iteractionMount;
    }
    public CommandsInvoker(){
        this.iteractionMount = 1;
    }

    private int iteractionMount, currentIteraction = 1;
    private Array <ICommand> commandsStack = new Array<ICommand>();
    private ICommand currentCommand;
    private int currentNum = 0;

    private CommandsInvoker interiorlnvoker;

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    public void addCommands(Array<ICommand> commands){
        commandsStack.clear();
        commandsStack.addAll(commands);
    }

    public Boolean hasCommand(){
        return currentNum < size();
    }

    public int size(){
        return commandsStack.size;
    }

    public void executeNext(RunningActor actor){
        if (!hasCommand())
            return;

        currentCommand = commandsStack.get(currentNum);

        if (currentCommand.executable())
        {
            currentCommand.executeOn(actor);
            currentNum++;
        }
        else {

            if (interiorlnvoker == null) {
                interiorlnvoker = new CommandsInvoker(currentCommand.getIterationsLength());
                interiorlnvoker.addCommands(currentCommand.getCommandsIncluded());
            }

            if (interiorlnvoker.hasCommand()) {
                interiorlnvoker.executeNext(actor);
            } else if (interiorlnvoker.hasIteraction()) {
                interiorlnvoker.nextIteraction();
                interiorlnvoker.executeNext(actor);
            } else {
                interiorlnvoker = null;
                currentNum++;
                executeNext(actor);
            }

        }

        //Gdx.app.log(this.toString(), "Command Num: " + currentNum);
    }

    public int getCurrentNum(){
        int index = commandsStack.indexOf(currentCommand, true);
        if (currentCommand.getClass() == CycleCommand.class && interiorlnvoker != null)
               return index - interiorlnvoker.size() + interiorlnvoker.getCurrentNum();
        return index;
    }
    public void reset(){
        commandsStack = new Array<ICommand>();
        currentCommand = null;
        currentNum = 0;
        currentIteraction = 1;
    }
    public Boolean hasIteraction(){
        return  (currentIteraction < iteractionMount);
    }

    public void nextIteraction(){
        currentIteraction++;
        currentNum = 0;
    }



}
