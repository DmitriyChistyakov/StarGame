package ru.gb.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import ru.gb.base.BaseScreen;
import ru.gb.math.Rect;
import ru.gb.sprite.Background;
import ru.gb.sprite.ExitButton;
import ru.gb.sprite.PlayButton;
import ru.gb.sprite.Star;

public class MenuScreen extends BaseScreen {

    private static final int STAR_COUNT = 256;

    private final Game game;

    private Texture bg;

    private TextureAtlas atlas;
    //    private Logo logo;
    private Background background;
    private Star[] stars;
    private ExitButton exitButton;
    private PlayButton playButton;
//    private Texture badlogic;
//    private Texture img;
//    private Texture imgFon;
//    private Vector2 pos;
//    private Vector2 v;
//    private Vector2 touch;
//    private static final float V_Len = 1.5f;

public MenuScreen(Game game) {
    this.game = game;
}

    @Override
    public void show() {
        super.show();
        bg = new Texture("textures/bg.png");
        background = new Background(bg);
        atlas = new TextureAtlas("textures/menuAtlas.tpack");
        stars = new Star[STAR_COUNT];
        for (int i = 0; i < stars.length; i++) {
            stars[i] = new Star(atlas);
        }
        exitButton = new ExitButton(atlas);
        playButton = new PlayButton(atlas, game);
//        badlogic = new  Texture("badlogic.jpg");
//        logo = new Logo(badlogic);
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
        for (Star star : stars) {
            star.resize(worldBounds);
        }
        exitButton.resize(worldBounds);
        playButton.resize(worldBounds);
//        star.resize(worldBounds);
//        logo.resize(worldBounds);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        update(delta);
        draw();
//        pos.add(v);
//        logo.update(delta);

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
        atlas.dispose();
//        badlogic.dispose();
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
        exitButton.touchDown(touch, pointer, button);
        playButton.touchDown(touch, pointer, button);
//        pos.set(touch);
//        logo.touchDown(touch, pointer,button);
        return false;
    }

    @Override
    public boolean touchUp(Vector2 touch, int pointer, int button) {
        exitButton.touchUp(touch, pointer, button);
        playButton.touchUp(touch, pointer, button);
        return false;
    }

    private void update(float delta) {
        for (Star star : stars) {
            star.update(delta);
        }
//        star.update(delta);

    }

    private void draw() {
        ScreenUtils.clear(0.33f, 0.45f, 0.68f, 1);
        batch.begin();
        background.draw(batch);
        for (Star star : stars) {
            star.draw(batch);
        }
        exitButton.draw(batch);
        playButton.draw(batch);
        batch.end();

    }
}
