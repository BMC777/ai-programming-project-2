package com.ucf.aigame.enginesystem;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.Input.Buttons;
import com.ucf.aigame.component.InputComponent;

import java.util.ArrayList;

/**
 * Created by Bryan on 3/13/2016.
 */
public class InputSystem implements EngineSystem
{
    private GameWorld gameWorld;
    private ArrayList<InputComponent> inputComponentList;
    private Input input;

    public InputSystem(GameWorld gameWorld)
    {
        this.gameWorld = gameWorld;
    }

    @Override
    public void updateSystem(double timeDelta)
    {
        inputComponentList = new ArrayList<InputComponent>(gameWorld.entityManager.getComponentsOfType(InputComponent
                .class));

        for (InputComponent inputComponent : inputComponentList)
        {

        }
    }

}