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
        if (Settings.IS_DEBUG)
            return null;
        return Primitives.getRect(Settings.TANK_WIDTH, Settings.TANK_HEIGHT);
    }

    @Override
    public float getWidth(){
        return Settings.TANK_WIDTH;
    }
    @Override
    public float getHeight(){
        return Settings.TANK_HEIGHT;
    }

}
