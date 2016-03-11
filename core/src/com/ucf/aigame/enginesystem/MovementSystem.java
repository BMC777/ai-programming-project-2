package com.ucf.aigame.enginesystem;

import com.ucf.aigame.component.Component;
import com.ucf.aigame.component.Position;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Bryan on 3/11/2016.
 */
public class MovementSystem implements EngineSystem
{
    private GameWorld gameWorld;
    private List<Position> positionComponentList;
    private ListIterator<Position> positionComponentIterator;
    private Position nextPositionComponent;

    public MovementSystem(GameWorld gameWorld )
    {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateSystem(double timeDelta)
    {
        positionComponentList = new LinkedList<Position>(gameWorld.entityManager.getComponentsWithAspect(Position.class));
        positionComponentIterator = positionComponentList.listIterator();

        while (positionComponentIterator.hasNext())
        {
            nextPositionComponent = positionComponentIterator.next();
            nextPositionComponent.height = 81;

            System.out.println(nextPositionComponent.height);
        }
    }
}
