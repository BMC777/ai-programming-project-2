package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.ucf.aigame.GameMain;
import com.ucf.aigame.utils.Point2D;

/**
 * Created by Bryan on 3/13/2016.
 */
public class PlayerTextureComponent extends Component
{
    public Texture playerTexture;
    public TextureRegion playerTextureRegion;

    public Point2D playerPosition;

    public PlayerTextureComponent()
    {
        playerTexture = new Texture(Gdx.files.internal("Player.png"));
        playerTextureRegion = new TextureRegion(playerTexture);
        playerPosition = new Point2D();
    }


}
