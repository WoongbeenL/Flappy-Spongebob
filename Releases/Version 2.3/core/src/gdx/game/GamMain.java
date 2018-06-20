package gdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GamMain extends Game {


    SpriteBatch batch;
    ScrPlay scrPlay;
    ScrMenu scrMenu;
    int nScreen;


    public void updateScreen(int _nScreen) {
        nScreen = _nScreen;
        if (nScreen == 0) setScreen(scrMenu);
        else if (nScreen == 1) setScreen(scrPlay);
    }

    @Override
    public void create() {
        nScreen = 0;
        batch = new SpriteBatch();
        scrMenu = new ScrMenu(this);
        scrPlay = new ScrPlay(this);
        updateScreen(0);
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
