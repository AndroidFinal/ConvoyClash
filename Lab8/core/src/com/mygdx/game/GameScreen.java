package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
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
    ActorBeta score;
    ActorBeta time;


    @Override
    public void initialize() {
        //Music gameMusic = Gdx.audio.newMusic(Gdx.files.internal("gameMusic.mp3"));
        //gameMusic.setLooping(true);
        //gameMusic.play();
      //  uiTable.background(skin.getDrawable("window-c"));

       // uiStage.addActor(tableContainer);

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

       // uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
      //  uiTable.add(startButton).size(startButton.getWidth(), startButton.getHeight()).expandX();

       // uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
       // uiTable.add(helpButton).size(helpButton.getWidth(), helpButton.getHeight()).expandX();

        foreground = new ActorBeta(0, 0, mainStage);
        foreground.loadTexture("sprites/backgrounds/convoybg.png");
        foreground.setSize(WIDTH, HEIGHT);
        ActorBeta placeholder = new ActorBeta(WIDTH /2 - 75,HEIGHT /2 -100, mainStage);
        placeholder.loadTexture("sprites/placeholder.png");
        placeholder.setScale(5.0f);
        ActorBeta scoretext = new ActorBeta(+75,HEIGHT -75, mainStage);
        scoretext.loadTexture("sprites/scoretext.png");
        scoretext.setScale(2.5f);
        ActorBeta timetext = new ActorBeta(WIDTH -350,HEIGHT -75, mainStage);
        timetext.loadTexture("sprites/timetext.png");
        timetext.setScale(2.5f);
        //background = new ActorBeta(900, 300, mainStage);
        //background.loadTexture("sprites/backgrounds/background0_20.png");
       // background.setScale(2.0f);
        uiStage.addActor(startButton);
        startButton.setPosition(150, HEIGHT/2);
        uiStage.addActor(helpButton);
        helpButton.setPosition(WIDTH -300, HEIGHT/2);
    }

    public void setUpButtons() {

        startButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Music sound = Gdx.audio.newMusic(Gdx.files.internal("powerup.wav"));
                sound.play();
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
                Music sound = Gdx.audio.newMusic(Gdx.files.internal("powerup.wav"));
                sound.play();
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