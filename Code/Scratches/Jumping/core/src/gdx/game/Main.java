package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

public class Main extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;
    Sprite sprite;
    float fGrav, fVelo, fX, fY;


    @Override
    public void create() {
        batch = new SpriteBatch();
        img = new Texture("Spongebob.png");
        sprite = new Sprite(img);
        fX = Gdx.graphics.getWidth() / 4 - sprite.getWidth() / 2;
        fY = Gdx.graphics.getHeight() / 2 - sprite.getHeight();
        sprite.setPosition(fX, fY);
        sprite.setScale(0.5f);

        fGrav = -0.09f;
        fVelo = 1f;
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        sprite.setY(fY);
        fVelo += fGrav;
        fY += fVelo;

        batch.begin();
        sprite.draw(batch);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            fVelo += 6;
        }
        System.out.println(fVelo);
        fVelo = MathUtils.clamp(fVelo, -5, 4);
    }

    @Override
    public void dispose() {
        batch.dispose();
        img.dispose();
    }
}
