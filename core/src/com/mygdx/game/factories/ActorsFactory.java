package com.mygdx.game.factories;

import com.mygdx.game.actors.EnemyActor;
import com.mygdx.game.actors.MainActor;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.actors.WallActor;
import com.mygdx.game.models.ActorType;

/**
 * Created by George on 11.02.2017.
 */

public class ActorsFactory {

    public static Class getActorByName(ActorType name){

        switch (name){
            case TANK_ACTOR:
                return TankActor.class;
            case WALL_ACTOR:
                return WallActor.class;
            case ENEMY_ACTOR:
                return EnemyActor.class;
        }
        return null;
    }

}
