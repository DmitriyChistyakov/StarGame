package ru.gb.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.gb.base.BaseScreen;
import ru.gb.math.Rect;
import ru.gb.sprite.Background;
import ru.gb.sprite.Logo;

public class MenuScreen extends BaseScreen {

    private Texture bg;
    private Logo logo;
    private Background background;
    private Texture badlogic;
//    private Texture img;
//    private Texture imgFon;
//    private Vector2 pos;
//    private Vector2 v;
//    private Vector2 touch;
//    private static final float V_Len = 1.5f;

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        badlogic = new  Texture("badlogic.jpg");
        logo = new Logo(badlogic);
//        imgFon = new Texture("fon.png");
//        img = new Texture("badlogic.jpg");
//        pos = new Vector2(-0.5f, -0.5f);
//        touch = new Vector2();
//        v = new Vector2();
    }

    @Override
    public void resize(Rect worldBounds) {
        super.resize(worldBounds);
        background.resize(worldBounds);
        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
//        pos.add(v);
        logo.update(delta);
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        logo.draw(batch);
//        batch.draw(imgFon, 0, 0);
//        batch.draw(img, pos.x, pos.y,1f,1f);
        batch.end();
//        if (touch.cpy().sub(pos).len() <= v.len()) {
//            pos.set(touch);
//            v.setZero();
//        } else {
//            pos.add(v);
//        }

    }

    @Override
    public void dispose() {
        super.dispose();
        bg.dispose();
        badlogic.dispose();
//        img.dispose();
    }

//    @Override
//    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
//        touch.set(screenX, Gdx.graphics.getHeight() - screenY);
//        v.set(touch.cpy().sub(pos).setLength(V_Len));
//        return false;
//        pos.set(screenX, Gdx.graphics.getHeight() - screenY);
//        return super.touchDown(screenX, screenY, pointer, button);
//    }


    @Override
    public boolean touchDown(Vector2 touch, int pointer, int button) {
//        pos.set(touch);
        logo.touchDown(touch, pointer,button);
        return false;
    }
}
