package com.mygdx.game;

/**
 * Created by markapptist on 2018-09-26.
 */

public class MyGame extends GameBeta {

    static MenuScreen menuScreen;
    static GameScreen gameScreen;
    static StoryScreen storyScreen;
    static VictoryScreen victoryScreen;
    static DefeatScreen defeatScreen;
    static HowToPlayScreen howToPlayScreen;


    boolean paused = false;

    @Override
    public void create() {

        super.create();

        menuScreen = new MenuScreen();

        setScreen(menuScreen);
    }

}
