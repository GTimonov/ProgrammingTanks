package com.mygdx.game.models;

import com.mygdx.game.actors.MainActor;

/**
 * Created by Goshan on 06.02.2017.
 */

public final class Cell {


    public void Cell(int x, int y){
        cellX = x;
        cellY = y;
    }

    ///////////////////////////////////////////////////////////////////////////
    // private props
    ///////////////////////////////////////////////////////////////////////////

    private int cellX;
    private int cellY;

    /**что находится в клетке*/
    private MainActor guest;

    ///////////////////////////////////////////////////////////////////////////
    // public props
    ///////////////////////////////////////////////////////////////////////////
    public int getCellX(){
        return cellX;
    }
    public int getCellY(){
        return cellY;
    }

    public void setGuest(MainActor guest){
        this.guest = guest;
    }
    public MainActor getGuest(){
        return guest;
    }

    public float guestRotation(){
       return guest.getRotation();
    }

}
