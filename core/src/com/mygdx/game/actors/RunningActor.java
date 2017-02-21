package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.MovingCommandsInvoker;
import com.mygdx.game.commands.RotateCommand;
import com.mygdx.game.utils.RotationValues;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 01.02.2017.
 */

public abstract class RunningActor extends MainActor {

    public RunningActor() {
        super();
        commandsInvoker = new MovingCommandsInvoker();
    }

    private MovingCommandsInvoker commandsInvoker;

    ///////////////////////////////////////////////////////////////////////////
    // public properties
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    //  public methods
    ///////////////////////////////////////////////////////////////////////////


    public void move(Vector2 position){

        float duration = position.len() / Settings.TANK_SPEED;
        MoveToAction action = Actions.action(MoveToAction.class);
        action.setPosition(position.x + getX(), position.y + getY());
        action.setDuration(duration);
        action.setInterpolation(getInterpolation());
        addAction(action);
    }
    public void rotate(int angle){

        float duration = Math.abs((float)angle / Settings.TANK_ROTATION_SPEED);
        RotateToAction action =  Actions.action(RotateToAction.class);
        action.setRotation(angle);
        action.setDuration(duration);
        action.setInterpolation(getInterpolation());
        addAction(action);

    }

    public void setCommands(Array<ICommand> commands){
        for (ICommand command: commands) {
            commandsInvoker.addCommand(command);
        }
    }

    public void applyCommand(){
        if (commandsInvoker.hasCommand())
            commandsInvoker.executeNext(this);
    }


    ///////////////////////////////////////////////////////////////////////////
    // override methods
    ///////////////////////////////////////////////////////////////////////////
    @Override
    public void draw(Batch batch, float alpha){
        if (!Settings.IS_DEBUG) {
            batch.draw(texture, this.getX(), getY(), this.getOriginX(), this.getOriginY(), this.getWidth(),
                    this.getHeight(), this.getScaleX(), this.getScaleY(), this.getRotation(), 0, 0,
                    (int)getWidth(), (int)getHeight(), false, false);
        }
    }

    @Override
    public void addAction(Action action){
        super.addAction(Actions.sequence(action, new RunnableAction(){
            public void run(){
                applyCommand();
            }
        }));
    }
    ///////////////////////////////////////////////////////////////////////////
    // private methods
    ///////////////////////////////////////////////////////////////////////////



    protected Interpolation getInterpolation(){
        return Interpolation.sine;
    }



}
