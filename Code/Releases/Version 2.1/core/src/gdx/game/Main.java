package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Sprite sprite;
    TextureRegion trBackground;
    float fX, fY, fVelo;

    @Override
    public void create() {
        batch = new SpriteBatch();
        trBackground = new TextureRegion(new Texture("background.png"), 0, 0, 700, 525);
        img = new Texture("Spongebob.png");
        sprite = new Sprite(img);
        fX = Gdx.graphics.getWidth() / 4 - sprite.getWidth() / 2;
        fY = Gdx.graphics.getHeight() / 2 - sprite.getHeight();
        sprite.setPosition(fX, fY);
        sprite.setScale(0.7f);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(45 / 255f, 233 / 255f, 255 / 255f, 1); //colour
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(trBackground, 0, 0);

        sprite.setY(fY);
        fY += fVelo;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fVelo += 6;
        }
        sprite.draw(batch);
        batch.end();
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
