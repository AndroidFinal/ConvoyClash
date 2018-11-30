package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
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

public class DefeatScreen extends ScreenBeta {

    TextButton exitButton;

    Label label;

    /**PARTICLE EFFECTS**/
    FireParticle fire;


    @Override
    public void initialize() {
        ActorBeta defeat = new ActorBeta(WIDTH /3 + 100,HEIGHT -150, mainStage);
        defeat.loadTexture("sprites/defeat.png");
        defeat.setScale(1.5f);
       // uiTable.background(skin.getDrawable("window-c"));

        //uiStage.addActor(tableContainer);

        exitButton = new TextButton("Main Menu", skin.get(("default"), TextButton.TextButtonStyle.class));
        exitButton.setOrigin(Align.center);
        exitButton.setTransform(true);
        exitButton.setScale(3);
        exitButton.setPosition(WIDTH / 2 - 75, 75);

        setUpButtons();

        label = new Label("LABEL", labelStyle);

        ActorBeta scoretext = new ActorBeta(WIDTH / 2 - 200,HEIGHT / 2 + 100, mainStage);
        scoretext.loadTexture("sprites/scoretext.png");
        scoretext.setScale(5.0f);

        ActorBeta hiscoretext = new ActorBeta(WIDTH / 2 - 425,HEIGHT / 2 - 100, mainStage);
        hiscoretext.loadTexture("sprites/hiscore.png");
        hiscoretext.setScale(1.0f);
        //Add to TABLE

       //uiTable.row().padTop(HEIGHT / 12).padBottom(HEIGHT / 12);
       // uiTable.add(exitButton).size(exitButton.getWidth(), exitButton.getHeight()).expandX();

        /**PARTICLE EFFECTS**/
        fire = new FireParticle();
        fire.centerAtActor(exitButton);
        fire.start();
        fire.setPosition(WIDTH / 2, HEIGHT / 2);
        fire.setScale(3.0f);
        uiStage.addActor(exitButton);
        mainStage.addActor(fire);
    }

    public void setUpButtons() {

        exitButton.addListener(new ActorGestureListener() {
            @Override
            public void touchDown(InputEvent event, float x, float y, int pointer, int button) {
                super.touchDown(event, x, y, pointer, button);
                Music sound = Gdx.audio.newMusic(Gdx.files.internal("powerup.wav"));
                sound.play();
                MyGame.setActiveScreen(MyGame.menuScreen);

            }
        });
    }

    @Override
    public void render(float delta) {super.render(delta);}

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
    }
}

