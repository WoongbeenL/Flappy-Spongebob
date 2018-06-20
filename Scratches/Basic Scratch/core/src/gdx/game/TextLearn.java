package gdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class TextLearn extends ApplicationAdapter {

    SpriteBatch batch;
    BitmapFont font;
    String sMyFont;
    GlyphLayout bounds;


    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont(Gdx.files.internal(".fnt"));
        sMyFont = "HELLO WORLD";
        GlyphLayout bounds = new GlyphLayout();
        bounds.setText(font, sMyFont);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        font.draw(batch, sMyFont, Gdx.graphics.getWidth() / 2 - bounds.width/2, Gdx.graphics.getHeight() / 2 + bounds.height/2);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();

    }
}
