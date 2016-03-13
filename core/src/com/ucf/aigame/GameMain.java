package com.ucf.aigame;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class GameMain extends Game
{
	public static final int GAME_WIDTH = 1024;
	public static final int GAME_HEIGHT = 1024;
	public static final int TILE_DIMENSIONS = 32;			//The game is tile-based with 32bit tile dimensions
	public static final int TILE_CENTER_OFFSET = 16;		//Offset used for center of entity calculations

	@Override
	public void create ()
	{
		//Creates a Screen to display the game on
		setScreen(new GameScreen());
	}

	@Override
	public void render ()
	{
		//Renders the Screens
		super.render();
		super.dispose();
	}

	@Override
	public void dispose()
	{
		super.dispose();
	}

    @Override
    public void setScreen(Screen screen)
    {
        super.setScreen(screen);
    }
}

