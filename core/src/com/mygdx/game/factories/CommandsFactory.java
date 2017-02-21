package com.mygdx.game.factories;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;
import com.mygdx.game.commands.ICommand;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.RotateCommand;
import com.mygdx.game.models.ActionTypes;
import com.mygdx.game.utils.RotationValues;

/**
 * Created by George on 18.02.2017.
 */

public class CommandsFactory {

    public static Array<ICommand> createCommands(Array<ActionTypes> types){
        Array<ICommand> commands = new Array<ICommand>();

        for (ActionTypes action: types) {
            switch (action){
                case WAIT:
                {
                    break;
                }
            }
        }

        //Array<ICommand> commands = CommandsFactory.createCommands(tankActor, model.getUserCommands());

        commands.add(new MoveCommand(2, 3));
        commands.add(new RotateCommand( -RotationValues.HALF));
        commands.add(new RotateCommand( -RotationValues.HALF));
        commands.add(new RotateCommand( -RotationValues.HALF));
        commands.add(new RotateCommand( -RotationValues.HALF));

        commands.add(new MoveCommand( 1, 1));
        commands.add(new RotateCommand( RotationValues.FOURTH));
        commands.add(new MoveCommand(3, 2));
        commands.add(new RotateCommand( RotationValues.FOURTH));
        return commands;
    }
}
