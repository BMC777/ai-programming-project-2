package com.ucf.aigame.enginesystem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ucf.aigame.EntityManager;

import com.ucf.aigame.GameMain;
import com.ucf.aigame.component.*;

/**
 * Created by Bryan on 2/13/2016.
 */
public class GameWorld
{
    protected final EntityManager entityManager;

    public GameWorld()
    {
        entityManager = new EntityManager();

        createGameMap();
        createPlayerEntity();
    }

    private void createGameMap()
    {
        for ( int x = 0; x < GameMain.GAME_WIDTH; x += GameMain.TILE_DIMENSIONS )
        {
            for ( int y = 0; y < GameMain.GAME_HEIGHT; y += GameMain.TILE_DIMENSIONS)
            {
                //Fill map with floor tiles.
                int floorEntityID = entityManager.createEntity();
                FloorTextureComponent floorTextureComponent = new FloorTextureComponent();

                floorTextureComponent.xPosition = x;
                floorTextureComponent.yPosition = y;

                System.out.println("Coordinate: (" + x + ", " + y + ")");

                entityManager.addComponent(floorEntityID, floorTextureComponent);

                //Border the map with walls
                if (x == 0 || x == GameMain.GAME_WIDTH - GameMain.TILE_DIMENSIONS || y == 0 || y == GameMain.GAME_HEIGHT - GameMain.TILE_DIMENSIONS)
                {
                    int wallEntityID = entityManager.createEntity();
                    WallTextureComponent wallTextureComponent = new WallTextureComponent();

                    wallTextureComponent.xPosition = x;
                    wallTextureComponent.yPosition = y;

                    entityManager.addComponent(wallEntityID, wallTextureComponent);
                }
            }
        }
    }

    private void createPlayerEntity()
    {
        int playerEntityID = entityManager.createEntity();
        PlayerTextureComponent playerTextureComponent;

        entityManager.addComponent(playerEntityID, new PlayerTextureComponent());
        entityManager.addComponent(playerEntityID, new PositionComponent());
    }
}
