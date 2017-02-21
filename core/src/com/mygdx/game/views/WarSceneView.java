package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.actors.WallActor;
import com.mygdx.game.models.GameModel;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 06.02.2017.
 */

public class WarSceneView extends Group implements  GameModel.IModelListener{

    public WarSceneView(GameModel model){

        this.model = model;

        model.addListener(this);
    }

    private TankActor tankActor;

    private ShapeRenderer debugRenderer;
    private GameModel model;



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

        tankActor.applyCommand();
    }

    private void moveEnemies(){

    }




    ///////////////////////////////////////////////////////////////////////////
    // GameModel.IModelEvents
    ///////////////////////////////////////////////////////////////////////////
    public void setupContent(){
        addWalls();
        addTank();
        tankActor.setCommands(model.getUserCommands());
    }

    public void start(){
        moveTank();
        moveEnemies();
    }
    public void stop(){}

    ///////////////////////////////////////////////////////////////////////////
    // override
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void act (float delta) {
        super.act(delta);

        if (Settings.IS_DEBUG)
        {
            if (debugRenderer == null)
                debugRenderer = new ShapeRenderer();
            debugRenderer.begin(ShapeRenderer.ShapeType.Line);
            debugRenderer.setColor(Color.RED);
            float screenWidth = Settings.CELLS_HORIZONTAL_COUNT * Settings.CELL_SIZE;
            float screenHeight = Settings.CELLS_VERTICAL_COUNT * Settings.CELL_SIZE;

            for (int i = 0; i < Settings.CELLS_HORIZONTAL_COUNT; i++)
                debugRenderer.line(0, i * Settings.CELL_SIZE, screenHeight,  i * Settings.CELL_SIZE);
            for (int i = 0; i < Settings.CELLS_VERTICAL_COUNT; i++)
                debugRenderer.line(i * Settings.CELL_SIZE, 0 , i * Settings.CELL_SIZE, screenWidth);
            debugRenderer.end();
        }
    }

}
