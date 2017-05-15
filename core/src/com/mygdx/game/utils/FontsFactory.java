package com.mygdx.game.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by Goshan on 02.12.2016.
 */


public abstract class FontsFactory {


    private static FreeTypeFontGenerator electrobyteGenerator;
    private static FreeTypeFontGenerator.FreeTypeFontParameter parameter;

    public static BitmapFont getElectrobyteFont(int size)
    {
        if (parameter == null) {
            parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();

            parameter.characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;,{}\"´`'<>";
        }
        parameter.size = size;
        parameter.borderStraight = true;
        parameter.borderColor = new Color(0xddffdd);
        parameter.spaceX = -(int)(size*.1);

        BitmapFont font = getElectrobyteGenerator().generateFont(parameter);
        //getElectrobyteGenerator().dispose();

        return font;
    }

    public static int getElectrobyteSizeBySquare(Vector2 size){

        int size_ = getElectrobyteGenerator().scaleToFitSquare((int)size.x, (int)size.y, 1);
        return size_;
    }

    private static FreeTypeFontGenerator getElectrobyteGenerator(){
        if (electrobyteGenerator == null)
            electrobyteGenerator = new FreeTypeFontGenerator(Gdx.files.internal("electrobyte.ttf"));
        return electrobyteGenerator;
    }



}
