package ru.gb.sprite;

import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

import ru.gb.base.Sprite;
import ru.gb.math.Rect;
import ru.gb.math.Rnd;

public class Star extends Sprite {

    private final Vector2 v;
    private Rect wordBounds;


    public Star(TextureAtlas atlas) {
        super(atlas.findRegion("star"));
        v = new Vector2();
        float vx = Rnd.nextFloat(-0.0005f, 0.0005f);
        float vy = Rnd.nextFloat(-0.1f, -0.05f);
        v.set(vx, vy);

    }

    @Override
    public void update(float delta) {
        super.update(delta);
        pos.mulAdd(v, delta);
        if (getRight() < wordBounds.getLeft()) {
            setLeft(wordBounds.getRight());
        }
        if (getLeft() > wordBounds.getRight()) {
            setRight(wordBounds.getLeft());
        }
        if (getTop() < wordBounds.getBottom()) {
            setBottom(wordBounds.getTop());
        }
        if (getBottom() > wordBounds.getTop()) {
            setTop(wordBounds.getBottom());
        }
        float height = getHeight();
        height += 0.0001f;
        if (height >= 0.012f) {
            height = 0.008f;
        }
        setHeightProportion(height);

    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        this.wordBounds = worldBounds;
        setHeightProportion(Rnd.nextFloat(0.005f, 0.013f));
        float x = Rnd.nextFloat(worldBounds.getLeft(), worldBounds.getRight());
        float y = Rnd.nextFloat(worldBounds.getBottom(), worldBounds.getTop());
        pos.set(x, y);
    }
}
