package at.test.mouse;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends Game {
	SpriteBatch batch;

	@Override
	public void create () {
		batch = new SpriteBatch();

		Screen gameScreen = new GameScreen();

		this.setScreen(gameScreen);
	}

	@Override
	public void dispose () {
		batch.dispose();
	}
}
