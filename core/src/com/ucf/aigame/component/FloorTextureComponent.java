package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ucf.aigame.GameMain;
import com.ucf.aigame.utils.Point2D;

/**
 * Created by Bryan on 3/13/2016.
 */
public class FloorTextureComponent extends Component
{
    public Texture floorTexture;
    public TextureRegion floorTextureRegion;

    public Point2D floorPosition;

    public FloorTextureComponent()
    {
        floorTexture = new Texture(Gdx.files.internal("Floor Tile.png"));
        floorTextureRegion = new TextureRegion( floorTexture );
        floorPosition = new Point2D();
    }
}
