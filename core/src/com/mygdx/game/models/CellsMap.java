package com.mygdx.game.models;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 21.02.2017.
 * управляет ячейками, столкновениями объектов
 */

public class CellsMap {

    public CellsMap(int sizeX, int sizeY){

        cells = new Rectangle[sizeX][sizeY];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells [i][j] = new Rectangle(i * Settings.CELL_SIZE, j * Settings.CELL_SIZE, Settings.CELL_SIZE, Settings.CELL_SIZE);
            }
        }

        Gdx.app.log("Cells Array: ", cells.toString());
    }

    public Array<Rectangle> getItemRectsByBounds(Rectangle bounds){
        Array<Rectangle> rects = new Array<Rectangle>();
        for (Rectangle[] horiz: cells) {
            for (Rectangle rect: horiz) {
                if (rect.overlaps(bounds))
                    rects.add(rect);
            }
        }
        return rects;
    }


    private Rectangle[][] cells;


}
