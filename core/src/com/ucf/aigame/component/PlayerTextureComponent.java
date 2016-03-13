package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ucf.aigame.GameMain;

/**
 * Created by Bryan on 3/13/2016.
 */
public class PlayerTextureComponent extends Component
{
    public Texture playerTexture = new Texture(Gdx.files.internal("Player.png"));

    public float xPosition = 128;
    public float yPosition = 128;

    public float width = GameMain.TILE_DIMENSIONS;
    public float height = GameMain.TILE_DIMENSIONS;
}
