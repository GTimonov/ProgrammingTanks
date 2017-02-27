package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateByAction;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MovingCommandsInvoker;
import com.mygdx.game.models.LevelModel;
import com.mygdx.game.utils.RotateHelper;
import com.mygdx.game.utils.Settings;
import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Created by Goshan on 01.02.2017.
 */

public abstract class RunningActor extends MainActor {

    public RunningActor(LevelModel levelModel) {
        super();
        commandsInvoker = new MovingCommandsInvoker();
        this.levelModel = levelModel;
    }

    private MovingCommandsInvoker commandsInvoker;

    private LevelModel levelModel;

    ///////////////////////////////////////////////////////////////////////////
    // public properties
    ///////////////////////////////////////////////////////////////////////////


    ///////////////////////////////////////////////////////////////////////////
    //  public methods
    ///////////////////////////////////////////////////////////////////////////


    public void move(){

        Vector2 vec = RotateHelper.getNextCellByRotation(getRotation());
        Vector2 nextCell = currentCell.cpy().add(vec);

        if (levelModel.checkCellForWall(nextCell))
        {

            if (RotateHelper.isRightAngle(getRotation())) {
                addAction(getRotateAction(RotateHelper.DUAL));
            }
            else {
                Vector2 rightCell = currentCell.cpy().add(RotateHelper.getNextCellByRotation(getRotation() - RotateHelper.FOURTH));
                Vector2 leftCell = currentCell.cpy().add(RotateHelper.getNextCellByRotation(getRotation() + RotateHelper.FOURTH));
                Boolean rightCellWall = levelModel.checkCellForWall(rightCell);//cправа стена
                Boolean leftCellWall = levelModel.checkCellForWall(leftCell);//слева стена

                if (!(rightCellWall ^ leftCellWall)) {
                    addAction(getRotateAction(RotateHelper.DUAL));
                }
                else if (leftCellWall) {
                    addAction(getBounceAction(rightCell, -RotateHelper.HALF));
                }
                else if (rightCellWall) {
                    addAction(getBounceAction(leftCell,RotateHelper.HALF));

                }
            }
        }
        else
        {
            addAction(getMoveAction(nextCell));
            currentCell = nextCell.cpy();
        }
    }
    public void waitStep(){
        waitAct();
    }
    public void rotate(int angle){
        addAction(getRotateAction(angle));
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

        super.addAction(Actions.sequence(action, new Action(){
            public boolean act (float delta){

                applyCommand();
                return true;
            }
        }));
    }


    ///////////////////////////////////////////////////////////////////////////
    // private methods
    ///////////////////////////////////////////////////////////////////////////



    protected Interpolation getInterpolation(){
        return Interpolation.sine;
    }

    protected float getSpeed(){
        return Settings.MAIN_SPEED;
    }

    private Action getBounceAction(Vector2 cell, int angle){
        return Actions.parallel(getMoveAction(cell), getRotateAction(angle));
    }

    private Action waitAct(){
        TemporalAction action = Actions.action(TemporalAction.class);
        action.setDuration(getSpeed());
        return action;
    }

    private Action getRotateAction(int angle){
        RotateByAction action =  Actions.action(RotateByAction.class);
        action.setAmount(angle);
        action.setDuration(getSpeed());
        action.setInterpolation(getInterpolation());
        return action;
    }
    private Action getMoveAction(Vector2 nextCell)
    {
        float x = getCartesianXbyCell(nextCell.x);
        float y = getCartesianYbyCell(nextCell.y);
        MoveToAction action = Actions.action(MoveToAction.class);
        action.setPosition(x, y);
        action.setDuration(getSpeed());
        action.setInterpolation(getInterpolation());
        return action;
    }


}
