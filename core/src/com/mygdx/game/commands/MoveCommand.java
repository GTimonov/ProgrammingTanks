package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand implements ICommand{

    private int toX;
    private int toY;
    private RunningActor runningActor;

    public MoveCommand(RunningActor actor, int toX, int toY) {
        this.toX = toX;
        this.toY = toY;
        runningActor = actor;
    }
    public void execute(){
        Vector2 distance = new Vector2(toX * Settings.CELL_SIZE, toY  * Settings.CELL_SIZE);
        runningActor.move(distance);
    }
}