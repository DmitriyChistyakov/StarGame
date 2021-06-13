package ru.gb.pool;

import com.badlogic.gdx.audio.Sound;

import ru.gb.base.SpritesPool;
import ru.gb.math.Rect;
import ru.gb.sprite.EnemyShip;

public class EnemyPool extends SpritesPool<EnemyShip> {

    private final Rect worldBounds;
    private final BulletPool bulletPool;
    private final Sound laserSound;

    public EnemyPool(Rect worldBounds, BulletPool bulletPool, Sound laserSound) {
        this.worldBounds = worldBounds;
        this.bulletPool = bulletPool;
        this.laserSound = laserSound;
    }

    @Override
    protected EnemyShip newObject() {
        return new EnemyShip(worldBounds, bulletPool,laserSound);
    }
}
