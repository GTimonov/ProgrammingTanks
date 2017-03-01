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

    public void startRunning(){
        model.start();
    }
    public void sropRunning(){

    }
    public void addCommand(){
        Array<ICommand> commands = new Array<ICommand>();
        commands.add(new WaitCommand());
        commands.add(new RotateCommand(-RotateHelper.FOURTH));
        commands.add(new RotateCommand(RotateHelper.FOURTH));
        commands.add(new CycleCommand(3, 2));
        commands.add(new RotateCommand(RotateHelper.DUAL));
        //commands.add(new WaitCommand());
        commands.add(new CycleCommand(5, 2));
        commands.add(new MoveCommand());
        model.setUserActions(commands);
    }
    public void removeCommand(){}

    public void setCurrentCommandNum(int num){
        model.currentCommandNum = num;
    }



}
