package com.mygdx.game.controls;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.RotateCommand;

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
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());
        commands.add(new MoveCommand());

//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand(-RotateHelper.HALF));
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand(RotateHelper.FOURTH));
//        commands.add(new MoveCommand());
//        commands.add(new MoveCommand());
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand( RotateHelper.FOURTH));
//        commands.add(new RotateCommand(-RotateHelper.HALF_DUAL));
//        commands.add(new RotateCommand(-RotateHelper.HALF));
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand( RotateHelper.FOURTH));
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand(-RotateHelper.HALF));
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand(RotateHelper.FOURTH));
//
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand( RotateHelper.FOURTH));
//        commands.add(new MoveCommand());
//        commands.add(new RotateCommand( RotateHelper.FOURTH));
        model.setUserActions(commands);
    }
    public void removeCommand(){}



}
