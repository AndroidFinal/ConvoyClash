package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import com.badlogic.gdx.scenes.scene2d.ui.Label;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.utils.Align;

import java.awt.TextField;

/**
 * Created by markapptist on 2018-11-15.
 */

public class DialogBox extends ActorBeta {

    private Label dialogLabel;
    private Label.LabelStyle labelStyle;
    private float padding = 16;

    private Skin skin;

    DialogBox(float x, float y, Stage s) {
        super(x, y, s);
        loadTexture("sprites/ui/dialog-translucent.png");

        dialogLabel = new Label(" ", skin, "default");
        dialogLabel.setWrap(true);
        dialogLabel.setPosition(padding, padding);
        this.setDialogSize(getWidth(), getHeight());
    }

    public void setDialogSize(float width, float height) {
        this.setSize(width, height);
        dialogLabel.setWidth(width - 2 * padding);
        dialogLabel.setHeight(height - 2 * padding);
    }

    public void setText(String text) {
        dialogLabel.setText(text);
    }

    public void setFontScale(float scale) {
        dialogLabel.setFontScale(scale);
    }

    public void setFontColor(Color color) {
        dialogLabel.setColor(color);
    }

    public void setBackgroundColor(Color color) {
        this.setColor(color);
    }

    public void alignTopLeft() {
        dialogLabel.setAlignment(Align.topLeft);
    }

    public void alignCenter() {
        dialogLabel.setAlignment(Align.center);
    }

}
