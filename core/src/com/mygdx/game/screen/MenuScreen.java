package com.mygdx.game.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.BaseScreen;

public class MenuScreen extends BaseScreen {

    private Texture baseImg;
    private Vector2 pos;
    private Vector2 direction;
    private Vector2 posEnd;
    private Vector2 speed;
    private Vector2 needDistance;
    private Vector2 traveledDistance;

    @Override
    public void show() {
        super.show();
        baseImg = new Texture("badlogic.jpg");
        pos = new Vector2();
        direction = new Vector2();
        posEnd = new Vector2();
        speed = new Vector2();
        needDistance = new Vector2();
        traveledDistance = new Vector2();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        batch.begin();
        batch.draw(baseImg, pos.x, pos.y);
        batch.end();
        move();
    }

    private void move() {
        direction = posEnd.cpy().sub(pos);
        speed = direction.nor().scl(5);
        traveledDistance.add(speed);
        if (traveledDistance.len()>needDistance.len()){
            pos.set(posEnd.x,posEnd.y);
            direction.set(0, 0);}
        pos.add(speed);
    }

    @Override
    public void dispose() {
        super.dispose();
        baseImg.dispose();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        posEnd.set(screenX, Gdx.graphics.getHeight() - screenY);
        needDistance = posEnd.cpy().sub(pos);
        traveledDistance.set(0,0);
        return super.touchDown(screenX, screenY, pointer, button);
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return super.touchDragged(screenX, screenY, pointer);
    }

}
