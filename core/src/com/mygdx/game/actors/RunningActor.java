package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.MovingCommandsInvoker;
import com.mygdx.game.commands.RotateCommand;

/**
 * Created by Goshan on 01.02.2017.
 */

public abstract class RunningActor extends MainActor {

    public RunningActor() {
        super();
        commandsInvoker = new MovingCommandsInvoker();
    }

    private MovingCommandsInvoker commandsInvoker;

    private Boolean isRunning = false;

    public void addMoveAction(int x, int y){
        commandsInvoker.addCommand(new MoveCommand(this, x, y));
    }

    public void addRotateAction(int degrees){
        commandsInvoker.addCommand(new RotateCommand(this, degrees));
    }

    public void startActions(){
        commandsInvoker.startCommands();
    }

    @Override
    public void draw(Batch batch, float alpha){
        batch.draw(texture,this.getX(),getY(),this.getOriginX(),this.getOriginY(),this.getWidth(),
                this.getHeight(),this.getScaleX(), this.getScaleY(),this.getRotation(),0,0,
                texture.getWidth(),texture.getHeight(),false,false);
    }


    @Override
    public void act(float delta){
        super.act(delta);
        commandsInvoker.act(delta);
    }


}
