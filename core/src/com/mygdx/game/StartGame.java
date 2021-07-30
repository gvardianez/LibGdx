package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class StartGame extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("Windows_shiny.png");
    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 1, 1, 1);
        batch.begin();
        batch.draw(img, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
