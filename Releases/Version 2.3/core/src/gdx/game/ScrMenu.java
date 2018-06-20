package gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScrMenu implements Screen, InputProcessor {
    GamMain game;
    SpriteBatch batch;
    Texture txTitle;
    Sprite sprTitle;
    BitmapFont bfFont;
    String sInstruction;
    boolean bScreen;
    int nX, nY;

    public ScrMenu(GamMain game) {
        this.game = game;
        this.batch = game.batch;
        txTitle = new Texture("Title.png");
        sprTitle = new Sprite(txTitle);
        bfFont = new BitmapFont();
        nX = Gdx.graphics.getWidth() / 2 - txTitle.getWidth() / 2;
        nY = Gdx.graphics.getHeight() / 2 - txTitle.getHeight() / 4;
        sInstruction = "Press Any Key to Play";
        sprTitle.setPosition(nX, nY);
        sprTitle.setScale(0.5f);
        bfFont.getData().setScale(3);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        sprTitle.draw(batch);
        bfFont.draw(batch, sInstruction, 110, 170);
        batch.end();

        if (Gdx.input.isKeyJustPressed(Input.Keys.ANY_KEY)) {
            game.updateScreen(1);
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        txTitle.dispose();
        bfFont.dispose();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void show() {

    }
}
