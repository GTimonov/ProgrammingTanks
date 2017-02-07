package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.actors.WallActor;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.MovingCommandsInvoker;
import com.mygdx.game.commands.RotateCommand;
import com.mygdx.game.utils.RotationValues;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 06.02.2017.
 */

public class WarSceneView extends Group implements RunningActor.OnFinishCallback{

    public WarSceneView(){
        commandsInvoker = new MovingCommandsInvoker();

        addWalls();
        addTank();
        moveTank();
    }

    private TankActor tankActor;
    private MovingCommandsInvoker commandsInvoker;
    private ShapeRenderer debugRendeder;

    private void addTank(){
        tankActor = new TankActor();
        tankActor.positionItemByCell(1, 0);




        this.addActor(tankActor);
    }

    private void addWalls(){
        for (int i = 0; i < 3; i++) {
            WallActor wallActor = new WallActor();
            wallActor.positionItemByCell((int)(Math.random()* Settings.CELLS_VERTICAL_COUNT), (int)(Math.random()* Settings.CELLS_HORIZONTAL_COUNT));
            this.addActor(wallActor);
        }
    }
    private void moveTank(){
        commandsInvoker.addCommand(new MoveCommand(tankActor, 2));
        commandsInvoker.addCommand(new RotateCommand(tankActor, -RotationValues.HALF));
        commandsInvoker.addCommand(new MoveCommand(tankActor, 1));
        commandsInvoker.addCommand(new RotateCommand(tankActor, RotationValues.FOURTH));
        commandsInvoker.addCommand(new MoveCommand(tankActor,3));
        commandsInvoker.addCommand(new RotateCommand(tankActor, RotationValues.FOURTH));

        tankActor.registerCallback(this);

        executeOneCommand();
    }


    private void executeOneCommand() {
        if (commandsInvoker.hasCommand())
            commandsInvoker.executeNext();
    }
    ///////////////////////////////////////////////////////////////////////////
    //  RunningActor.OnFinishCallback implements
    ///////////////////////////////////////////////////////////////////////////

    public void onFinishRunning(){
        executeOneCommand();
    }

    ///////////////////////////////////////////////////////////////////////////
    // override
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void act (float delta) {
        super.act(delta);

        if (Settings.IS_DEBUG)
        {
            if (debugRendeder == null)
                debugRendeder = new ShapeRenderer();
            debugRendeder.begin(ShapeRenderer.ShapeType.Line);
            debugRendeder.setColor(Color.RED);
            float screenWidth = Settings.CELLS_HORIZONTAL_COUNT * Settings.CELL_SIZE;
            float screenHeight = Settings.CELLS_VERTICAL_COUNT * Settings.CELL_SIZE;

            for (int i = 0; i < Settings.CELLS_HORIZONTAL_COUNT; i++)
                debugRendeder.line(0, i * Settings.CELL_SIZE, screenHeight,  i * Settings.CELL_SIZE);
            for (int i = 0; i < Settings.CELLS_VERTICAL_COUNT; i++)
                debugRendeder.line(i * Settings.CELL_SIZE, 0 , i * Settings.CELL_SIZE, screenWidth);
            debugRendeder.end();
        }
    }

}
