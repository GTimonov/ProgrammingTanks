package com.mygdx.game.models;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.CycleCommand;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 31.01.2017.
 */

public class GameModel {
    ///////////////////////////////////////////////////////////////////////////
    // construcor
    ///////////////////////////////////////////////////////////////////////////
    public GameModel(){

        this.cellsMap = new CellsMap(Settings.WIDTH_IN_CELLS, Settings.HEIGHT_IN_CELLS);
        listeners = new Array();
    }

    ///////////////////////////////////////////////////////////////////////////
    // private
    ///////////////////////////////////////////////////////////////////////////


    private Array<IModelListener> listeners;

    private Array<ICommand> userCommands;

    ///////////////////////////////////////////////////////////////////////////
    // public
    ///////////////////////////////////////////////////////////////////////////

    public LevelModel levelModel;

    public CellsMap cellsMap;

    public int currentCommandNum;


    public interface IModelListener{
        void start();
        void stop();
        void setupContent();
    }

    public void setLevel(LevelModel level){
        this.levelModel = level;
    }
    public void setUserActions(Array<ICommand> actions){
        userCommands =  actions;
    }
    public Array<ICommand> getUserCommands(){
        return userCommands;
    }

    public void createLevel(){

        for (IModelListener listener: listeners) {
            listener.setupContent();
        }
    }
    public void start(){
        for (IModelListener listener: listeners) {
            listener.start();
        }
    }
    public void stop(){
        for (IModelListener listener: listeners) {
            listener.stop();
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    // observe methods
    ///////////////////////////////////////////////////////////////////////////

    public void addListener(IModelListener listener){
        listeners.add(listener);
    }

    public void removeListener(IModelListener listener){
        listeners.removeValue(listener, true);
    }




}
