package gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamMain extends Game {


    SpriteBatch batch;
    ScrPlay scrPlay;
    ScrMenu scrMenu;


    @Override
    public void create() {
        batch = new SpriteBatch();
        scrPlay = new ScrPlay(this);
        scrMenu = new ScrMenu(this);
    }

    public void updateScreen(int nScreen) {
        if (nScreen == 0) setScreen(scrPlay);
        if (nScreen == 1) setScreen(scrMenu);
    }

    @Override
    public void render() {
        super.render();
    }


    @Override
    public void dispose() {
        super.dispose();
    }
}
