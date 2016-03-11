package com.ucf.aigame.enginesystem;

import com.ucf.aigame.EntityManager;
import com.ucf.aigame.component.Position;
import com.ucf.aigame.component.Sprite;

/**
 * Created by Bryan on 2/13/2016.
 */
public class GameWorld
{
    protected final EntityManager entityManager;
    //private final ComponentManager componentManager;

    public GameWorld()
    {
        entityManager = new EntityManager();

        createPlayerEntity();
    }

    private void createPlayerEntity()
    {
        int playerEntityID =  entityManager.createEntity();

        Sprite playerSpriteComponent = new Sprite();
        Position playerPositionComponent = new Position();

        playerPositionComponent.width = 32;
        playerPositionComponent.height = 32;

        System.out.println(playerPositionComponent.width);

        entityManager.addComponent(playerEntityID, playerSpriteComponent);
        entityManager.addComponent(playerEntityID, playerPositionComponent);
    }

}
