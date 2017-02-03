package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.MyTanksGame;
import com.mygdx.game.actors.TankActor;
import com.mygdx.game.commands.MoveCommand;
import com.mygdx.game.commands.MovingCommandsInvoker;
import com.mygdx.game.commands.RotateCommand;
import com.mygdx.game.utils.RotationValues;
import com.mygdx.game.views.CommandsButtonsView;

import javafx.scene.transform.Rotate;

/**
 * Created by Goshan on 31.01.2017.
 */

public class GameScreen extends ScreenAdapter {

    private Stage stage;
    private SpriteBatch batch;
    private FPSLogger logger;
    private TankActor tankActor;
    private CommandsButtonsView commandsButtons;
    private MovingCommandsInvoker commandsInvoker;
    private Boolean runCommands = false;


    public GameScreen(MyTanksGame game)
    {
        stage = game.stage;
        batch = game.batch;
        logger = new FPSLogger();
        commandsInvoker = new MovingCommandsInvoker();
    }

    @Override
    public void show() {
        addTank();
        addCommands();
        moveTank();
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
        //tankActor.setY(i);
        //logger.log();
        //Gdx.app.log("delta  ", Float.toString(delta));

        if (runCommands)
            executeCommands();


    }

    @Override
    public void dispose () {
        batch.dispose();
    }

    private void addTank(){
        tankActor = new TankActor();
        stage.addActor(tankActor);
    }

    private void moveTank(){
        commandsInvoker.addCommand(new MoveCommand(tankActor, 1, 1));
        commandsInvoker.addCommand(new MoveCommand(tankActor, 2, 0));
        commandsInvoker.addCommand(new RotateCommand(tankActor, RotationValues.DUAL));
        commandsInvoker.addCommand(new RotateCommand(tankActor, -RotationValues.DUAL));
        commandsInvoker.addCommand(new RotateCommand(tankActor, RotationValues.HALF));

        executeCommands();

    }
    private void addCommands(){

        commandsButtons = new CommandsButtonsView();
        stage.addActor(commandsButtons);
    }

    private void executeCommands(){
        if (!tankActor.getIsRunningNow() && !tankActor.getIsRotateNow()) {
            Boolean executed = commandsInvoker.executeNext();
            runCommands = executed;
        }
    }

}
