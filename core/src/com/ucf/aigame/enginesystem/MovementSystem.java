package com.ucf.aigame.enginesystem;

import com.ucf.aigame.component.PositionComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Bryan on 3/11/2016.
 */
public class MovementSystem implements EngineSystem
{
    private GameWorld gameWorld;
    private List<PositionComponent> positionComponentList;
    private ListIterator<PositionComponent> positionComponentIterator;
    private PositionComponent nextPositionComponent;

    public MovementSystem(GameWorld gameWorld )
    {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateSystem(double timeDelta)
    {
        positionComponentList = new ArrayList<PositionComponent>(gameWorld.entityManager.getComponentsOfType(PositionComponent.class));
    }
}
