package gdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class ScrPlay implements Screen, InputProcessor {

    GamMain game;
    SpriteBatch batch;
    Texture txSB, txInstr;
    Sprite sprSB, sprInstr;
    TextureRegion trBackground;
    float fX, fY, fVelo, fGrav;
    boolean bStart;

    public ScrPlay(GamMain game) {
        this.game = game;
        this.batch = game.batch;

        trBackground = new TextureRegion(new Texture("background.png"), 0, 0, 700, 525);
        txSB = new Texture("Spongebob.png");
        txInstr = new Texture("Instruction.png");
        sprSB = new Sprite(txSB);
        sprInstr = new Sprite(txInstr);
        fX = Gdx.graphics.getWidth() / 4 - sprSB.getWidth() / 2;
        fY = Gdx.graphics.getHeight() / 2 - sprSB.getHeight();
        bStart = false;
        sprSB.setPosition(fX, fY);
        sprSB.setScale(0.7f);
        sprInstr.setScale(0.5f);
        sprInstr.setPosition(Gdx.graphics.getWidth() / 2 - sprInstr.getWidth() / 2,
                Gdx.graphics.getHeight() / 2 - sprInstr.getHeight() / 2);
        fGrav = -0.09f;
        fVelo = 0;

        Gdx.input.setInputProcessor(this);
    }


    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if (!bStart) {
            batch.begin();
            batch.draw(trBackground, 0, 0);
            sprInstr.draw(batch);
            batch.end();
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                bStart = true;
                fVelo = 1;
            }
        }
        if (bStart) {
            Gdx.gl.glClearColor(45 / 255f, 233 / 255f, 255 / 255f, 1); //colour
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

            batch.begin();
            batch.draw(trBackground, 0, 0);
            sprSB.draw(batch);
            batch.end();

            sprSB.setY(fY);
            fVelo += fGrav;
            fY += fVelo;

            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                fVelo += 7;
            }

            fVelo = MathUtils.clamp(fVelo, -7, 4);
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
        txSB.dispose();
        txInstr.dispose();
        batch.dispose();
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
}
