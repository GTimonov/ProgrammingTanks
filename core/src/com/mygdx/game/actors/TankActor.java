package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.utils.Primitives;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 31.01.2017.
 */

public class TankActor extends RunningActor {


    public TankActor (){
        super();

    }
    @Override
    protected Texture createTexture(){
        return Primitives.getRect(Settings.TANK_WIDTH, Settings.TANK_HEIGHT);
    }


}
