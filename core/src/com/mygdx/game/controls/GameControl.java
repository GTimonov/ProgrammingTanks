package com.mygdx.game.controls;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.CycleCommand;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.RotateCommand;

import com.mygdx.game.commands.WaitCommand;
import com.mygdx.game.models.GameModel;
import com.mygdx.game.utils.RotateHelper;


/**
 * Created by George on 11.02.2017.
 */

public class GameControl {

    private GameModel model;
    public GameControl(GameModel model){
        this.model = model;
    }
    private Array<ICommand> commands = new Array<ICommand>();

    public void startRunning(){
        model.start();
    }
    public void sropRunning(){

    }
    public void addCommand(){
        commands.add(new WaitCommand(5));
        commands.add(new MoveCommand(2));
        commands.add(new RotateCommand(-RotateHelper.DUAL));
        commands.add(new CycleCommand(createCycleCommands(2), 2));
        commands.add(new RotateCommand(RotateHelper.DUAL));
        commands.add(new CycleCommand(createCycleCommands(4), 2));
        commands.add(new MoveCommand(5));
        model.setUserActions(commands);
    }
    public void removeCommand(){}

    public void setCurrentCommandNum(int num){
        model.currentCommandNum = num;
    }


    private Array<ICommand> createCycleCommands(int mount){

        Array<ICommand> items = new Array<ICommand>();
        int lenght = commands.size;
        for (int i = lenght - mount; i < lenght; i++) {
            items.add(commands.get(i));
        }
        return items;
    }
}
