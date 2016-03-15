package com.ucf.aigame.enginesystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL30;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ucf.aigame.GameMain;
import com.ucf.aigame.component.*;

import javax.swing.text.Position;
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

    private List<FloorTextureComponent> floorTextureComponentList;
    private List<WallTextureComponent> wallTextureComponentList;
    private List<PlayerTextureComponent> playerTextureComponentList;

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
        floorTextureComponentList = gameWorld.entityManager.getComponentsOfType(FloorTextureComponent.class);
        wallTextureComponentList = gameWorld.entityManager.getComponentsOfType(WallTextureComponent.class);
        playerTextureComponentList = gameWorld.entityManager.getComponentsOfType(PlayerTextureComponent.class);

        Gdx.gl.glClearColor(0, 0, 0, 1);    //RGB and Alpha values are used when OpenGL pixel color buffers are cleared.
        Gdx.gl.glClear(GL30.GL_COLOR_BUFFER_BIT);   //Clears the pixel color buffers for future color writing.

        batcher.begin();

        //Rendering all textures in layer order.
        for ( FloorTextureComponent floorTextureComponent : floorTextureComponentList )
        {
            batcher.draw( floorTextureComponent.floorTexture, floorTextureComponent.floorPosition.getX(), floorTextureComponent.floorPosition.getY());
        }

        for ( WallTextureComponent wallTextureComponent : wallTextureComponentList )
        {
            batcher.draw( wallTextureComponent.wallTexture, wallTextureComponent.wallPosition.getX(), wallTextureComponent.wallPosition.getY());
        }

        for ( PlayerTextureComponent playerTextureComponent : playerTextureComponentList )
        {
            batcher.draw( playerTextureComponent.playerTexture, playerTextureComponent.playerPosition.getX(), playerTextureComponent.playerPosition.getY());
        }

        batcher.end();
    }
}
