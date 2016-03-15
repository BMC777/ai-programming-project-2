package com.ucf.aigame.enginesystem;



import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Bryan on 3/11/2016.
 */
public class MovementSystem implements EngineSystem
{
    private GameWorld gameWorld;

    public MovementSystem(GameWorld gameWorld )
    {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateSystem(double timeDelta)
    {
    }
}
