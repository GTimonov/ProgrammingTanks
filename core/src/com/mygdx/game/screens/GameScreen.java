package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.utils.Align;
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

    private VerticalGroup mainVGroup;
    private WarSceneView warScene;

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


        addViews();

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


    private void addViews(){

        mainVGroup = new VerticalGroup();
        mainVGroup.setSize(stage.getWidth(), stage.getHeight());
        stage.addActor(mainVGroup);

        warScene = new WarSceneView(gameModel, levelModel);
        warScene.setSize(stage.getWidth(), (Settings.HEIGHT_IN_CELLS) * Settings.CELL_SIZE);
        mainVGroup.addActor(warScene);

        commandsButtons = new CommandsButtonsView();
        float height = stage.getWidth() / Settings.COMMANDS_STACK_LENGTH * Settings.COMMANDS_STACK_HEIGHT;
        commandsButtons.setSize(stage.getWidth(),height);
        mainVGroup.addActor(commandsButtons);
        mainVGroup.wrap(false);
    }






}
