package com.mygdx.game.views;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.mygdx.game.actors.MainActor;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.actors.WallActor;
import com.mygdx.game.models.GameModel;
import com.mygdx.game.models.LevelModel;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 06.02.2017.
 */

public class WarSceneView extends Group implements  GameModel.IModelListener{

    public WarSceneView(GameModel model, LevelModel levelModel){

        this.model = model;
        this.levelModel = levelModel;
        model.addListener(this);
    }

    private TankActor tankActor;

    private ShapeRenderer debugRenderer;
    private GameModel model;
    private LevelModel levelModel;


    private void addTank(){

        tankActor = (TankActor) levelModel.getTank();
        this.addActor(tankActor);
    }

    private void addWalls(){
        for (MainActor wall: levelModel.getWalls()) {
            this.addActor(wall);
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
        this.levelModel = model.levelModel;
        addWalls();
        addTank();

    }

    public void start(){
        tankActor.setCommands(model.getUserCommands());
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
