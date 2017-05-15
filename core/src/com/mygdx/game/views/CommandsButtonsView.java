package com.mygdx.game.views;


import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.Settings;

/**
 * Created by Goshan on 31.01.2017.
 */

public class CommandsButtonsView extends Table  {

    private TextButton.TextButtonStyle textButtonStyle;
    private ButtonGroup btnGroup;
    private Array<CommandHolder> holders;

    public CommandsButtonsView (){

        super();
        holders = new Array<CommandHolder>(20);
        createStyles();
        setBounds(getX(),getY(),getWidth(),getHeight());
        createButtons();
        debugTable();
    }


    private void createButtons(){
        Table table = new Table();
        table.setBounds(getX(),getY(),getWidth(),getHeight());
        this.addListener(new InputListener() {
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                onClick(event, x, y);
                return false;
            }
        });
        int rowsLength = 2;
        int holderNum = 1;
        for (int i = 0; i < rowsLength; i++) {
            for (int j = 0; j < Settings.COMMANDS_STACK_LENGTH/rowsLength; j++) {
                CommandHolder holder = new CommandHolder(Integer.toString(holderNum));
                add(holder);
                holders.add(holder);
                holderNum++;
            }
            row();
        }
    }

    @Override
    public void setSize (float width, float height) {
        super.setSize(width, height);
        int rowsLength = 2;
        float size = getWidth()/Settings.COMMANDS_STACK_LENGTH*rowsLength;
        for (CommandHolder holder:holders) {
            holder.setSize(size, size);
        }
    }


    private void createStyles(){
        textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.font = new BitmapFont();

    }
    private void onClick(InputEvent event, float x, float y){
        Actor hitted = hit(x, y, true);
        if (hitted !=null && hitted instanceof CommandHolder )
            hitOnHolder((CommandHolder)hitted);
    }
    private void hitOnHolder(CommandHolder holder){
        System.out.println("down " + holder.num);
        showCommandsCategories();
    }
    private void showCommandsCategories(){

    }
}
