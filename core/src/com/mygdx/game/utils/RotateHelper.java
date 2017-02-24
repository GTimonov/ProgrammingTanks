package com.mygdx.game.utils;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Goshan on 02.02.2017.
 */

public final class RotateHelper {

    public static final int FOURTH = 45;
    public static final int HALF = 90;
    public static final int HALF_DUAL = 135;
    public static final int DUAL = 180;

    public static final Vector2 getNextCellByRotation(float rotation){
        Vector2 vec = Vector2.Y;
        vec.setAngle(rotation + HALF);
        vec.x = (float) MathUtils.round(vec.x);
        vec.y = (float) MathUtils.round(vec.y);
        return vec;
    }

    public static Boolean isRightAngle (float rotation){
        if (rotation == 0 || rotation % HALF == 0)
            return true;
        return false;
    }


}