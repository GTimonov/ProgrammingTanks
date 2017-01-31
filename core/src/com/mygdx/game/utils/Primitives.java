package com.mygdx.game.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

import java.util.Random;

/**
 * Created by Goshan on 31.01.2017.
 */

public class Primitives {

    private final static byte RECT_TYPE = 0;
    private final static byte CIRCLE_TYPE = 1;

    public static Texture getRect(int width, int height, Color color) {
        return  getTexture(width, height, color, RECT_TYPE);
    }
    public static Texture getRect(int width, int height) {
        Color color = getRandomColor();
        return  getTexture(width, height, color, RECT_TYPE);
    }
    public static Texture getRect(int width) {
        Color color = getRandomColor();
        return  getTexture(width, width, color, RECT_TYPE);
    }
    public static Texture getCircle(int diameter,  Color color) {
        return  getTexture(diameter, diameter, color, CIRCLE_TYPE);
    }
    public static Texture getCircle(int diameter) {
        Color color = getRandomColor();
        return  getTexture(diameter, diameter, color, CIRCLE_TYPE);
    }

    private static Texture getTexture(int width, int height, Color color, Byte type){

        Pixmap pm = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pm.setColor(color);
        switch (type){
            case CIRCLE_TYPE:
                pm.fillCircle(width/2-1 , width/2-1, width/2-1);
                break;
            case RECT_TYPE:
                pm.fillRectangle(0, 0, width, height);
                break;
        }
        Texture texture = new Texture(pm);
        pm.dispose();
        return  texture;
    }

    private static Color getRandomColor (){
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        Color color = new Color(r, g, b, 1);
        return color;
    }
}
