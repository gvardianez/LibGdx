package com.mygdx.game.pool;

import com.mygdx.game.base.SpritesPool;
import com.mygdx.game.math.Rect;
import com.mygdx.game.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final Rect worldBounds;
    private final BulletPool bulletPool;

    public EnemyPool(Rect worldBounds, BulletPool bulletPool) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
    }

    @Override
    protected EnemyShip newSprite() {
        return new EnemyShip(worldBounds, bulletPool);
    }

}
