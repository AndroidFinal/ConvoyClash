package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by markapptist on 2018-11-12.
 */

public class GameScreen extends ScreenBeta {

    TextButton startButton;
    TextButton helpButton;


    Label label;

    /**PARTICLE EFFECTS**/


    ActorBeta foreground;
    ActorBeta background;


    @Override
    public void initialize() {

        uiTable.background(skin.getDrawable("window-c"));

        uiStage.addActor(tableContainer);

        startButton = new TextButton("Victory", skin.get(("default"), TextButton.TextButtonStyle.class));
        startButton.setOrigin(Align.center);
        startButton.setTransform(true);
        startButton.setScale(3);

        helpButton = new TextButton("Defeat", skin.get(("default"), TextButton.TextButtonStyle.class));
        helpButton.setOrigin(Align.center);
        helpButton.setTransform(true);
        helpButton.setScale(3);

        setUpButtons();

        label = new Label("LABEL", labelStyle);

        //Add to TABLE

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(startButton).size(startButton.getWidth(), startButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(helpButton).size(helpButton.getWidth(), helpButton.getHeight()).expandX();

        foreground = new ActorBeta(0, 0, mainStage);
        foreground.loadTexture("sprites/backgrounds/background0_59.png");
        foreground.setSize(WIDTH, HEIGHT);

        background = new ActorBeta(900, 300, mainStage);
        background.loadTexture("sprites/backgrounds/background0_20.png");
        background.setScale(2.0f);
    }

    public void setUpButtons() {

        startButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                if(MyGame.victoryScreen == null) {
                    MyGame.victoryScreen = new VictoryScreen();
                    MyGame.setActiveScreen(MyGame.victoryScreen);
                }
                else{
                    MyGame.setActiveScreen(MyGame.victoryScreen);
                }
            }
        });

        helpButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                if(MyGame.defeatScreen == null) {
                    MyGame.defeatScreen = new DefeatScreen();
                    MyGame.setActiveScreen(MyGame.defeatScreen);
                }
                else{
                    MyGame.setActiveScreen(MyGame.defeatScreen);
                }
            }
        });

    }

    @Override
    public void render(float delta) {super.render(delta);
        Gdx.gl.glClearColor(1, 1, 1, 1);}

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void update(float dt) {

    }
}