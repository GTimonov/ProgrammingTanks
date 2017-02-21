package com.mygdx.game.models;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.factories.CommandsFactory;

import java.util.ArrayList;

/**
 * Created by Goshan on 31.01.2017.
 */

public class GameModel {
    ///////////////////////////////////////////////////////////////////////////
    // construcor
    ///////////////////////////////////////////////////////////////////////////
    public GameModel(LevelModel levelModel){
        this.levelModel = levelModel;
        listeners = new Array();
    }

    ///////////////////////////////////////////////////////////////////////////
    // private
    ///////////////////////////////////////////////////////////////////////////
    private LevelModel levelModel;

    private Array<IModelListener> listeners;

    private Array<ActionTypes> userActions;
    private Array<ICommand> userCommands;

    ///////////////////////////////////////////////////////////////////////////
    // public
    ///////////////////////////////////////////////////////////////////////////
    public interface IModelListener{
        void start();
        void stop();
        void setupContent();
    }

    public void setUserActions(Array<ActionTypes> actions){


        userActions.addAll(
                ActionTypes.MOVE,
                ActionTypes.MOVE,
                ActionTypes.ROTATE_LEFT,
                ActionTypes.ROTATE_RIGHT,
                ActionTypes.ROTATE_RIGHT,
                ActionTypes.MOVE,
                ActionTypes.ROTATE_RIGHT,
                ActionTypes.WAIT,
                ActionTypes.MOVE
        );

        userActions = actions;
    }
    public Array<ICommand> getUserCommands(){
        return userCommands;
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

    public void createLevel(){

        Array<ActionTypes> actionsUpdated = levelModel.updatePath(userActions);
        userCommands = CommandsFactory.createCommands(actionsUpdated);

        for (IModelListener listener: listeners) {
            listener.setupContent();
        }
    }
}
