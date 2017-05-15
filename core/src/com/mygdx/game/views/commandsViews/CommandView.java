package com.mygdx.game.views.commandsViews;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.commands.ICommand;

/**
 * Created by Goshan on 02.03.2017.
 */

public class CommandView extends Actor implements ICommandView {

    private ICommand command;
    protected Texture texture;

    public CommandView(ICommand command){
        this.command = command;
        setBounds(getX(),getY(),getWidth(),getHeight());
        texture = createTexture(command);
    }
    public ICommand getCommand(){
        return command;
    }

    protected Texture createTexture(ICommand command){

        return null;
    }

}
