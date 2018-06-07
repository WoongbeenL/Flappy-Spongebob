package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    TextureRegion trBackground;

    @Override
    public void create() {
        batch = new SpriteBatch();
        trBackground = new TextureRegion(new Texture("background.png"), 0, 0, 700, 525);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(45 / 255f, 233 / 255f, 255 / 255f, 1); //colour
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(trBackground, 0, 0);
        batch.draw(trBackground, 0, Gdx.graphics.getHeight());
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
