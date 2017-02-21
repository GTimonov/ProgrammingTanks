package com.mygdx.game.models;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.factories.ActorsFactory;

/**
 * Created by George on 11.02.2017.
 */

public class LevelModel {
    public LevelModel(int levelNum){
        parceLevel(levelNum);
    }

    public void parceLevel(int levelNum){
        ActorsFactory fact = new ActorsFactory();
        ActorsFactory.getActorByName(ActorType.ENEMY_ACTOR);

    }
    /**проверяет путь объекта на столкновения и преобразует его*/
    public Array<ActionTypes> updatePath(Array<ActionTypes> commands){



        return new Array<ActionTypes>();
    }
}
