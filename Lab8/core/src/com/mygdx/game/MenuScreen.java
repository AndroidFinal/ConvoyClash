package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Button.ButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ActorGestureListener;
import com.badlogic.gdx.utils.Align;

/**
 * Created by markapptist on 2018-11-12.
 */

public class MenuScreen extends ScreenBeta {

    TextButton startButton;
    TextButton helpButton;
    TextButton exitButton;

    Label label;

    /**PARTICLE EFFECTS**/
    FireParticle fire;
    FlameParticle flame;
    WarpParticle warp;


    @Override
    public void initialize() {
        Music menuMusic = Gdx.audio.newMusic(Gdx.files.internal("bgMusic.mp3"));
        menuMusic.setLooping(true);
        menuMusic.play();
        menuMusic.setVolume(0.4f);


        uiTable.background(skin.getDrawable("window-c"));

        uiStage.addActor(tableContainer);


        startButton = new TextButton("Play", skin.get(("default"), TextButton.TextButtonStyle.class));
        startButton.setOrigin(Align.center);
        startButton.setTransform(true);
        startButton.setScale(3);

        helpButton = new TextButton("How To Play", skin.get(("default"), TextButton.TextButtonStyle.class));
        helpButton.setOrigin(Align.center);
        helpButton.setTransform(true);
        helpButton.setScale(3);

        exitButton = new TextButton("Story", skin.get(("default"), TextButton.TextButtonStyle.class));
        exitButton.setOrigin(Align.center);
        exitButton.setTransform(true);
        exitButton.setScale(3);

        setUpButtons();

        label = new Label("LABEL", labelStyle);

        //Add to TABLE

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(startButton).size(startButton.getWidth(), startButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(helpButton).size(helpButton.getWidth(), helpButton.getHeight()).expandX();

        uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
        uiTable.add(exitButton).size(exitButton.getWidth(), exitButton.getHeight()).expandX();

        ActorBeta title = new ActorBeta(WIDTH /4,HEIGHT -150, uiStage);
        title.loadTexture("sprites/title.png");
        title.setScale(1.5f);

        /**PARTICLE EFFECTS**/
        fire = new FireParticle();
        fire.centerAtActor(startButton);
        fire.start();
        fire.setPosition(WIDTH / 2, HEIGHT / 2);
        fire.setScale(3.0f);

        flame = new FlameParticle();
        flame.centerAtActor(startButton);
        flame.start();
        flame.setPosition(WIDTH / 4, HEIGHT / 2);
        flame.setScale(2.0f);

        warp = new WarpParticle();
        warp.centerAtActor(startButton);
        warp.start();
        warp.setPosition(WIDTH / 1.25f, HEIGHT / 2);
        warp.setScale(2.0f);

        mainStage.addActor(fire);
        //mainStage.addActor(flame);
        //mainStage.addActor(warp);
    }

    public void setUpButtons() {


        startButton.addListener(new ActorGestureListener() {

            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);

                Music sound = Gdx.audio.newMusic(Gdx.files.internal("start.wav"));
                sound.play();

                if(MyGame.gameScreen == null) {

                    MyGame.gameScreen = new GameScreen();
                    MyGame.setActiveScreen(MyGame.gameScreen);
                }
                else{
                    MyGame.setActiveScreen(MyGame.gameScreen);
                }
            }
        });

        helpButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Music sound = Gdx.audio.newMusic(Gdx.files.internal("powerup.wav"));
                sound.play();
                if(MyGame.howToPlayScreen == null) {
                    MyGame.howToPlayScreen = new HowToPlayScreen();
                    MyGame.setActiveScreen(MyGame.howToPlayScreen);
                }
                else{
                    MyGame.setActiveScreen(MyGame.howToPlayScreen);
                }
            }
        });

        exitButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Music sound = Gdx.audio.newMusic(Gdx.files.internal("powerup.wav"));
                sound.play();
               // uiStage.addAction(Actions.fadeOut(1.0f));
                if(MyGame.storyScreen == null) {
                    MyGame.storyScreen = new StoryScreen();
                    MyGame.setActiveScreen(MyGame.storyScreen);
                }
                else{
                    MyGame.setActiveScreen(MyGame.storyScreen);
                }

            }
        });
    }

    @Override
    public void render(float delta) {super.render(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);}

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
        fire.act(dt);
        flame.act(dt);
        warp.act(dt);
    }
}
