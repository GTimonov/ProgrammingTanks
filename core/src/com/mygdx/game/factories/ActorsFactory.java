package com.mygdx.game.factories;

import com.mygdx.game.actors.MainActor;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.models.ActorType;

/**
 * Created by George on 11.02.2017.
 */

public class ActorsFactory {

    public static MainActor getActorByName(ActorType name){

        switch (name){
            case TANK_ACTOR:
                return new TankActor();
            case WALL_ACTOR:
                break;
            case ENEMY_ACTOR:
                break;
        }
        return null;
    }

}
