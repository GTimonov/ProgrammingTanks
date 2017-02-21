package com.mygdx.game.commands;

import com.mygdx.game.actors.RunningActor;

/**
 * Created by Goshan on 02.02.2017.
 */

public interface ICommand {
    void executeOn(RunningActor actor);
}
