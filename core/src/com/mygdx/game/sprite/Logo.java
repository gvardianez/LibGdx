package com.mygdx.game.sprite;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.base.Sprite;
import com.mygdx.game.math.Rect;

public class Logo extends Sprite {

    private static final float V_LEN = 0.002f;
    private Vector2 touch;
    private Vector2 speed;

    public Logo(Texture texture) {
        super(new TextureRegion(texture));
        this.touch = new Vector2();
        this.speed = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        setHeightProportion(0.2f);
    }

    @Override
    public void update(float delta) {
        if (touch.dst(pos) > V_LEN) {
            pos.add(speed);
        } else {
            pos.set(touch);
        }
    }

    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
        this.touch.set(touch);
        speed.set(touch.cpy().sub(pos)).setLength(V_LEN);
        return false;
    }


}
