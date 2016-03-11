package com.ucf.aigame.enginesystem;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Bryan on 2/13/2016.
 */
public class RenderSystem implements EngineSystem
{
    private OrthographicCamera camera;
    private SpriteBatch batcher;
    private ShapeRenderer shapeRenderer;

    public RenderSystem(GameWorld gameWorld)
    {

    }

    private void initializeAssets()
    {

    }

    @Override
    public void updateSystem(double timeDelta)
    {

    }
}
