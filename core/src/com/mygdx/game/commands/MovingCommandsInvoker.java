package com.mygdx.game.commands;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;


/**
 * Created by Goshan on 02.02.2017.
 */

public class MovingCommandsInvoker {

    protected Array <ICommand> commandsStack = new Array<ICommand>();
    protected ICommand currentCommand;
    protected int currentNum = 0;

    private CycleCommandsInvoker cycleCommandInvoker;

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    public void addCommand(ICommand command){
        commandsStack.add(command);
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

        if (cycleCommandInvoker==null){
            if (!isCycle(currentCommand)) {
                currentCommand = commandsStack.get(currentNum);
                currentCommand.executeOn(actor);
                currentNum++;
                return;
            }
        }
        else
        {
            if (cycleCommandInvoker.hasCommand())
            {
                cycleCommandInvoker.executeNext(actor);
                return;
            }
        }

        if (isCycle(currentCommand)) {
            if (cycleCommandInvoker != null) {
                if (cycleCommandInvoker.hasIteraction()) {
                    cycleCommandInvoker.nextIteraction();
                }
                else {
                    cycleCommandInvoker = null;
                    currentNum++;
                }
                executeNext(actor);
            }
            else {
                addCycle();
                executeNext(actor);
            }
        }

        //Gdx.app.log(this.toString(), "Command Num: " + currentNum);
    }

    public int getCurrentNum(){
        if (!isCycle(currentCommand))
            return currentNum ;
        else if (cycleCommandInvoker != null)
            return currentNum - (cycleCommandInvoker.size() - cycleCommandInvoker.getCurrentNum());
        return currentNum;
    }
    public void reset(){
        commandsStack = new Array<ICommand>();
        currentCommand = null;
        currentNum = 0;
    }

    ///////////////////////////////////////////////////////////////////////////
    // private utils
    ///////////////////////////////////////////////////////////////////////////

    private Boolean isCycle(ICommand command){
        return command.getClass() == CycleCommand.class;
    }


    private void addCycle(){
        CycleCommand cycleCommand = (CycleCommand)currentCommand;
        if (cycleCommand.getCommandsLength() > currentNum) {
            Gdx.app.error("Довыебывался", "дохуя комманд в цикле", new Throwable());
            return;
        }
        cycleCommandInvoker = new CycleCommandsInvoker(cycleCommand.getIterationsLength());
        cycleCommandInvoker.reset();
        for (int i = currentNum - cycleCommand.getCommandsLength(); i < currentNum; i++) {
            cycleCommandInvoker.addCommand(commandsStack.get(i));
        }
    }
}
