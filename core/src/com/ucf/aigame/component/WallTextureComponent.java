package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ucf.aigame.GameMain;
import com.ucf.aigame.utils.Point2D;

/**
 * Created by Bryan on 3/13/2016.
 */
public class WallTextureComponent extends Component
{
    public Texture wallTexture;
    public TextureRegion wallTextureRegion;

    public Point2D wallPosition;

    public WallTextureComponent()
    {
        wallTexture = new Texture(Gdx.files.internal("Wall Tile.png"));
        wallTextureRegion = new TextureRegion(wallTexture);
        wallPosition = new Point2D();
    }
}
