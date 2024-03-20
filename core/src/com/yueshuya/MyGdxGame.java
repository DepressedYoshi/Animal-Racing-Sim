package com.yueshuya;

import com.badlogic.gdx.Game;

public class MyGdxGame extends Game {
	/*TODO
	*  radom annla genration
	*  beartification
	*  UI
	*  Famer inter face */

	@Override
	public void create() {
		setScreen(new GamePlayScreen());
	}
}
