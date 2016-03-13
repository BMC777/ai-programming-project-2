package com.ucf.aigame;

import com.badlogic.gdx.Screen;
import com.ucf.aigame.enginesystem.GameWorld;
import com.ucf.aigame.enginesystem.MovementSystem;
import com.ucf.aigame.enginesystem.RenderSystem;

/**
 * Created by Bryan on 2/13/2016.
 */
public class GameScreen implements Screen
{
    private GameWorld gameWorld;

    private final MovementSystem movementSystem;
    private final RenderSystem renderSystem;

    //Time game clock is behind system clock
    private float lagTime = 0;

    private static final float MS_PER_UPDATE = 0.016666667f;      //Game update locks at 60FPS [(1 / 60)SPF]

    public GameScreen()
    {
        gameWorld = new GameWorld();

        movementSystem = new MovementSystem( gameWorld );
        renderSystem = new RenderSystem( gameWorld );
    }

    @Override
    public void show()
    {

    }

    @Override
    public void render(float delta)
    {
        lagTime += delta; //Update lagTime for current frame.
        //***INPUT PROCESSING HERE***

        //Catching up game time to real time
        while (lagTime >= MS_PER_UPDATE)
        {
            movementSystem.updateSystem(lagTime);
            //***CHECK FOR COLLISIONS HERE***

            lagTime -= MS_PER_UPDATE;
        }

        renderSystem.updateSystem(lagTime);
        //graphics.render(lagTime / MS_PER_UPDATE);     //Render graphics after accounting for game time lag
    }

    @Override
    public void resize(int width, int height)
    {

    }

    @Override
    public void pause()
    {

    }

    @Override
    public void resume()
    {

    }

    @Override
    public void hide()
    {

    }

    @Override
    public void dispose()
    {

    }
}
