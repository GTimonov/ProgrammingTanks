package com.mygdx.game.views;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

/**
 * Created by Goshan on 31.01.2017.
 */

public class CommandsButtonsView extends Table  {

    private TextButton.TextButtonStyle textButtonStyle;

    public CommandsButtonsView (){

        super();

        createStyles();
        createButtons();
        setBounds(getX(),getY(),getWidth(),getHeight());
        debugTable();
        //wrap(true);
        //rowCenter();
        //space(50);
        //fill();
        //space(10);
        //pad(10);
    }


    private void createButtons(){
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                TextButton btn = new TextButton(Integer.toString(i)+Integer.toString(j), textButtonStyle);

                btn.addListener(new ChangeListener() {
                    public void changed (ChangeEvent event, Actor actor) {
                        Gdx.app.log("Button clicked", event.toString());
                    }
                });
                add(btn).width(64).height(64);

            }
            row();

        }

    }
    private void createStyles(){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont();

    }
}
