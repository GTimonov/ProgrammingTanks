package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
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
        nextCell = currentCell.add(vec);

        if (levelModel.checkCellForWall(nextCell))
        {
            if (RotateHelper.isRightAngle(getRotation()))
                bounceBackAct();
            else {
                Vector2 rightCell = RotateHelper.getNextCellByRotation(getRotation() - RotateHelper.FOURTH);
                Vector2 leftCell = RotateHelper.getNextCellByRotation(getRotation() + RotateHelper.FOURTH);
                Boolean rightCellWall = levelModel.checkCellForWall(rightCell);//cправа стена
                Boolean leftCellWall = levelModel.checkCellForWall(leftCell);//слева стена

                if (!(rightCellWall ^ leftCellWall))
                    bounceBackAct();
                else if (leftCellWall)
                    bounceRightAct(leftCell);
                else if (rightCellWall)
                    bounceLeftAct(rightCell);
            }
        }
        else
        {
            moveAct(nextCell);
        }
    }
    public void waitStep(){
        waitAct();
    }
    public void rotate(int angle){
        rotateAct(angle);
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
                currentCell = nextCell;

                applyCommand();
            }
        }));
    }
    ///////////////////////////////////////////////////////////////////////////
    // private methods
    ///////////////////////////////////////////////////////////////////////////

    protected Vector2 nextCell;

    protected Interpolation getInterpolation(){
        return Interpolation.sine;
    }

    protected float getSpeed(){
        return Settings.MAIN_SPEED;
    }

    private void bounceBackAct(){
        rotateAct(RotateHelper.DUAL);
    }
    private void bounceRightAct(Vector2 rightCell){
        moveAct(rightCell);
        rotateAct(RotateHelper.HALF);
    }
    private void bounceLeftAct(Vector2 leftCell){
        moveAct(leftCell);
        rotateAct(-RotateHelper.HALF);
    }

    private void waitAct(){
        TemporalAction action = Actions.action(TemporalAction.class);
        action.setDuration(getSpeed());
        addAction(action);
    }

    private void rotateAct(int angle){
        RotateToAction action =  Actions.action(RotateToAction.class);
        action.setRotation(angle + getRotation());
        action.setDuration(getSpeed());
        action.setInterpolation(getInterpolation());
        addAction(action);
    }
    private void moveAct(Vector2 nextCell)
    {
        float x = getCartesianXbyCell(nextCell.x);
        float y = getCartesianYbyCell(nextCell.y);
        MoveToAction action = Actions.action(MoveToAction.class);
        action.setPosition(x, y);
        action.setDuration(getSpeed());
        action.setInterpolation(getInterpolation());
        addAction(action);
    }


}
