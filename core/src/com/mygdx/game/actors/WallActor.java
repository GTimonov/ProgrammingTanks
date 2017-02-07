package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.utils.Primitives;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 07.02.2017.
 */

public class WallActor extends MainActor {

    @Override
    public float getWidth(){
        return Settings.CELL_SIZE;
    }
    @Override
    public float getHeight(){
        return Settings.CELL_SIZE;
    }

    @Override
    protected Texture createTexture(){
        if (Settings.IS_DEBUG)
            return null;
        return Primitives.getRect(Settings.CELL_SIZE, Settings.CELL_SIZE);
    }
}
