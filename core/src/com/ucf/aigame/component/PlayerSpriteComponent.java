package com.ucf.aigame.component;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Bryan on 3/13/2016.
 */
public class PlayerSpriteComponent extends Component
{
    public Texture sprite = new Texture(Gdx.files.internal("Player.png"));

    public float xPosition = 640;
    public float yPosition = 640;

    public float width = 64;
    public float height = 64;
}
