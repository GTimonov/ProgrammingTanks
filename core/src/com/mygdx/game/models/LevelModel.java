package com.mygdx.game.models;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.EnemyActor;
import com.mygdx.game.actors.MainActor;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.actors.WallActor;
import com.mygdx.game.factories.ActorsFactory;
import com.mygdx.game.utils.RotateHelper;
import com.mygdx.game.utils.Settings;

/**
 * Created by George on 11.02.2017.
 * парсит карту и хранит инфу об объектах-актерах
 */

public class LevelModel {
    public LevelModel(int levelNum){
        parceLevel(levelNum);
    }

    private RunningActor tank;
    private Array<MainActor> walls;
    private Array<MainActor> enemies;

    ///////////////////////////////////////////////////////////////////////////
    // public methods
    ///////////////////////////////////////////////////////////////////////////

    public void parceLevel(int levelNum){
        ActorsFactory fact = new ActorsFactory();

        createTank();
        createWalls();
        createEnemies();

    }

    public RunningActor getTank(){
        return tank;
    }
    public Array<MainActor> getWalls(){
        return walls;
    }
    public Array<MainActor> getEnemies(){
        return enemies;
    }

    public Boolean checkCellForWall(Vector2 cell){
        if (cell.x < 0 || cell.x > Settings.WIDTH_IN_CELLS || cell.y < 0 || cell.y > Settings.HEIGHT_IN_CELLS)
            return true;
        for (MainActor wall: walls)
            if (cell.equals(wall.getCurrentCell()))
                return true;
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////
    // private methods
    ///////////////////////////////////////////////////////////////////////////

    private void createTank(){
        Class item = ActorsFactory.getActorByName(ActorType.TANK_ACTOR);
        tank = new TankActor(this);
        tank.positionItemByCell(4, 2);
        //tank.setRotation(-RotateHelper.FOURTH);

    }
    private void createWalls(){
        walls = new Array<MainActor>();

//        MainActor q = new WallActor();
//        q.positionItemByCell(1, 2);
//        walls.add(q);
//
//        MainActor w = new WallActor();
//        w.positionItemByCell(2, 2);
//        walls.add(w);

//        MainActor e = new WallActor();
//        e.positionItemByCell(2, 1);
//        walls.add(e);

    }
    private void createEnemies(){
        enemies = new Array<MainActor>();
        for (int i = 0; i < 2; i++) {
            MainActor enemyActor = new EnemyActor(this);
            enemyActor.positionItemByCell((int)(Math.random()* Settings.WIDTH_IN_CELLS), (int)(Math.random()* Settings.HEIGHT_IN_CELLS));
            enemies.add(enemyActor);
        }
    }

}
