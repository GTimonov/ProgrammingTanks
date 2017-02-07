package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand implements ICommand{

    private int cellsCount;
    private RunningActor runningActor;

    public MoveCommand(RunningActor actor, int cellsCount) {
        this.cellsCount = cellsCount;
        runningActor = actor;
    }
    public void execute(){
        float angle = runningActor.getRotation();
        double distance = (cellsCount * Settings.CELL_SIZE);
        if (Math.abs(Math.tan(angle)) == 1)
            distance = Math.sqrt(2) * distance;

        Vector2 vec = new Vector2(0, 1);
        vec.rotate(angle);
        vec.setLength((float)distance);
        vec.x = (float)Math.floor((double)vec.x);
        vec.y = (float)Math.floor((double)vec.y);
        //Vector2 distance = new Vector2(toX * Settings.CELL_SIZE, toY  * Settings.CELL_SIZE);
        runningActor.move(vec);



    }
}