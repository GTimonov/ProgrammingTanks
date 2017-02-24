package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.MyTanksGame;
import com.mygdx.game.controls.GameControl;
import com.mygdx.game.models.GameModel;
import com.mygdx.game.models.LevelModel;
import com.mygdx.game.utils.Settings;
import com.mygdx.game.views.CommandsButtonsView;
import com.mygdx.game.views.WarSceneView;

/**
 * Created by Goshan on 31.01.2017.
 */

public class GameScreen extends ScreenAdapter {

    private Stage stage;
    private SpriteBatch batch;
    private FPSLogger logger;
    private ShapeRenderer debugRenderer;

    private CommandsButtonsView commandsButtons;
    private GameModel gameModel;
    private GameControl gameControl;
    private LevelModel levelModel;



    public GameScreen(MyTanksGame game, LevelModel levelModel)
    {
        this.levelModel = levelModel;
        gameModel = new GameModel();
        gameModel.setLevel(levelModel);
        stage = game.stage;
        batch = game.batch;
        logger = new FPSLogger();
        if (Settings.IS_DEBUG)
            stage.setDebugAll(true);
        addCommands();

    }


    @Override
    public void render(float delta) {
        super.render(delta);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


        //logger.log();
        //Gdx.app.log("delta  ", Float.toString(delta));
    }

    @Override
    public void show(){
        super.show();



        gameControl = new GameControl(gameModel);

        stage.addActor(new WarSceneView(gameModel, levelModel));
        gameModel.createLevel();
        gameControl.addCommand();
        gameControl.startRunning();
    }

    @Override
    public void dispose () {
        batch.dispose();
    }

    ///////////////////////////////////////////////////////////////////////////
    //  private utils
    ///////////////////////////////////////////////////////////////////////////


    private void addCommands(){
        commandsButtons = new CommandsButtonsView();
        stage.addActor(commandsButtons);
    }






}
