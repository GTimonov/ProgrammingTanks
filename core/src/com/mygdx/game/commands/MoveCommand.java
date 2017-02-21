package com.mygdx.game.commands;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.utils.RotationValues;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 02.02.2017.
 */

public class MoveCommand implements ICommand{

    //private int cellsCount;

    private  int cell_x;
    private  int cell_y;
//    private RunningActor runningActor;

    public MoveCommand(int cell_x, int cell_y) {
       // this.cellsCount = cellsCount;
//        runningActor = actor;
        this.cell_x = cell_x;
        this.cell_y = cell_y;
    }
    public void executeOn(RunningActor actor){
        Vector2 vec = new Vector2(cell_x * Settings.CELL_SIZE, cell_y * Settings.CELL_SIZE);
        actor.move(vec);

//        float angle = runningActor.getRotation();
//        double distance = (cellsCount * Settings.CELL_SIZE);
//        if (Math.abs(Math.tan(angle)) == 1)
//            distance = Math.sqrt(2) * distance;
//
//        Vector2 vec = new Vector2(0, 1);
//        vec.rotate(angle);
//        vec.setLength((float)distance);
//        vec.x = (float)Math.floor((double)vec.x);
//        vec.y = (float)Math.floor((double)vec.y);
//        //Vector2 distance = new Vector2(toX * Settings.CELL_SIZE, toY  * Settings.CELL_SIZE);
//        runningActor.move(vec);







    }
}