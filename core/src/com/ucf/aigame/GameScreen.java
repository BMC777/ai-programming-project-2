package com.ucf.aigame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ucf.aigame.enginesystem.GameWorld;
import com.ucf.aigame.enginesystem.MovementSystem;
import com.ucf.aigame.enginesystem.RenderSystem;

/**
 * Created by Bryan on 2/13/2016.
 */
public class GameScreen implements Screen
{
    private OrthographicCamera camera;
    private SpriteBatch batcher;

    private GameWorld gameWorld;
    private final MovementSystem movementSystem;
    private final RenderSystem renderSystem;

    //Time game clock is behind system clock
    private float lagTime;

    private static final float MS_PER_UPDATE = 0.016666667f;      //Game update locks at 60FPS [(1 / 60)SPF]

    public GameScreen()
    {
        lagTime = 0;

        //camera allows displaying of textures onto the GameScreen. Setting to Orthographic for a 2D effect.
        camera = new OrthographicCamera();
        camera.setToOrtho( false, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT );

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix( camera.combined );   //batcher draws textures using camera's coordinate system.

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

        Gdx.gl.glClearColor(0, 0, 0, 1);    //RGB and Alpha values are used when OpenGL pixel color buffers are cleared.
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);   //Clears the pixel color buffers for future color writing.

        //***INPUT PROCESSING HERE***

        //Catching up game time to real time
        while (lagTime >= MS_PER_UPDATE)
        {
            movementSystem.updateSystem(lagTime);
            //***CHECK FOR COLLISIONS HERE***

            lagTime -= MS_PER_UPDATE;
        }

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
