package com.mygdx.game.commands;

import com.badlogic.gdx.utils.Array;
import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public interface ICommand {
    /**выолненить комманду на Актере*/
    void executeOn(RunningActor actor);

    /**может ли команда выполнится в целом**/
    Boolean executable();

    /**содержит команды*/
    Array<ICommand> getCommandsIncluded();

    /**количество итераций*/
    int getIterationsLength();
}
