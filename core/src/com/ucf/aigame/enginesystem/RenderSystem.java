package com.ucf.aigame.enginesystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.ucf.aigame.GameMain;
import com.ucf.aigame.GameScreen;
import com.ucf.aigame.component.PlayerSpriteComponent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Bryan on 2/13/2016.
 */
public class RenderSystem implements EngineSystem
{
    private GameWorld gameWorld;
    private SpriteBatch batcher;
    private OrthographicCamera camera;

    private List<PlayerSpriteComponent> playerSpriteComponentList;

    public RenderSystem(GameWorld gameWorld)
    {
        this.gameWorld = gameWorld;

        //camera allows displaying of textures onto the GameScreen. Setting to Orthographic for a 2D effect.
        camera = new OrthographicCamera();
        camera.setToOrtho( false, GameMain.GAME_WIDTH, GameMain.GAME_HEIGHT );

        batcher = new SpriteBatch();
        batcher.setProjectionMatrix( camera.combined );   //batcher draws textures using camera's coordinate system.
    }

    @Override
    public void updateSystem(double timeDelta)
    {
        playerSpriteComponentList = new ArrayList<PlayerSpriteComponent>(gameWorld.entityManager.getComponentsOfType(PlayerSpriteComponent.class));

        Gdx.gl.glClearColor(0, 0, 0, 1);    //RGB and Alpha values are used when OpenGL pixel color buffers are cleared.
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);   //Clears the pixel color buffers for future color writing.

        batcher.begin();

        for ( PlayerSpriteComponent playerSpriteComponent : playerSpriteComponentList)
        {
            batcher.draw(playerSpriteComponent.sprite, playerSpriteComponent.xPosition, playerSpriteComponent.yPosition, playerSpriteComponent.width, playerSpriteComponent.height);
        }

        batcher.end();
    }
}
