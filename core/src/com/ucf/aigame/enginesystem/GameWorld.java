package com.ucf.aigame.enginesystem;

import com.ucf.aigame.EntityManager;

import com.ucf.aigame.component.InputComponent;
import com.ucf.aigame.component.PlayerSpriteComponent;
import com.ucf.aigame.component.PositionComponent;

/**
 * Created by Bryan on 2/13/2016.
 */
public class GameWorld
{
    protected final EntityManager entityManager;

    public GameWorld()
    {
        entityManager = new EntityManager();

        createPlayerEntity();
    }

    private void createPlayerEntity()
    {
        int playerEntityID =  entityManager.createEntity();

        entityManager.addComponent(playerEntityID, new PlayerSpriteComponent());
        entityManager.addComponent(playerEntityID, new PositionComponent());
        entityManager.addComponent(playerEntityID, new InputComponent());
    }

    private void createGameMap()
    {

    }

}
