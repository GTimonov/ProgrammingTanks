package com.mygdx.game.utils;

/**
 * Created by Goshan on 31.01.2017.
 */

public class Settings {
    public final static Boolean IS_DEBUG = true;

    public final static int TANK_WIDTH = 40;
    public final static int TANK_HEIGHT = 60;

    public final static int CELL_SIZE = 64;
    public final static int WIDTH_IN_CELLS = 10;
    public final static int HEIGHT_IN_CELLS =9;

    /**количество клеток в секунду или пол оборота*/
    public final static int MAIN_SPEED = 1;


    /**коефициент скорости такнка откносительно MAIN_SPEED*/
    public final static float TANK_CELLSPEED = 5f;

    /**максимальное количество команд**/
    public final static int COMMANDS_STACK_LENGTH = 40;
    /**максимальное количество команд**/
    public final static int COMMANDS_STACK_HEIGHT = 2;


}
