package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.ucf.aigame.GameMain;

/**
 * Created by Bryan on 3/13/2016.
 */
public class WallTextureComponent extends Component
{
    public Texture wallTexture = new Texture(Gdx.files.internal("Wall Tile.png"));

    public float xPosition;
    public float yPosition;

    public float width = GameMain.TILE_DIMENSIONS;
    public float height = GameMain.TILE_DIMENSIONS;
}
