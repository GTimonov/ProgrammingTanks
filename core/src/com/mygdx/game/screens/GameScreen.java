package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.mygdx.game.MyTanksGame;
import com.mygdx.game.actors.TankActor;

/**
 * Created by Goshan on 31.01.2017.
 */

public class GameScreen extends ScreenAdapter {

    private Stage stage;
    private SpriteBatch batch;
    FPSLogger logger;
    TankActor tankActor;

    public GameScreen(MyTanksGame game)
    {
        stage = game.stage;
        batch = game.batch;
        logger = new FPSLogger();
    }

    @Override
    public void show() {
        addTank();
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
        MoveToAction moveAction = new MoveToAction();
        moveAction.setPosition(300f, 0f);
        moveAction.setDuration(10f);
        tankActor.addAction(moveAction);
    }

}
