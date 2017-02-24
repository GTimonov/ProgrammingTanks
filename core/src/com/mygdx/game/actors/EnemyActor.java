package com.mygdx.game.actors;

import com.badlogic.gdx.graphics.Texture;
import com.mygdx.game.models.LevelModel;
import com.mygdx.game.utils.Primitives;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 21.02.2017.
 */

public class EnemyActor extends RunningActor {

    public EnemyActor (LevelModel levelModel){
        super(levelModel);

    }

    @Override
    protected Texture createTexture(){
        if (Settings.IS_DEBUG)
            return null;
        return Primitives.getRect(Settings.CELL_SIZE, Settings.CELL_SIZE);
    }
}
