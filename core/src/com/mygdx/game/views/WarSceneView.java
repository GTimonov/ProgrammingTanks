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
    protected void drawDebugBounds (ShapeRenderer shapes) {
        super.drawDebugBounds(shapes);
        if (Settings.IS_DEBUG)
        {
            shapes.setColor(Color.RED);

            for (int i = 0; i < Settings.HEIGHT_IN_CELLS; i++)
                shapes.line(getX(), i * Settings.CELL_SIZE + getY(), getWidth() + getX(),  i * Settings.CELL_SIZE + getY());
            for (int j = 0; j < Settings.WIDTH_IN_CELLS; j++)
                shapes.line(j * Settings.CELL_SIZE + getX(), getY() , j * Settings.CELL_SIZE + getX(), getHeight() + getY());
        }
    }
}
