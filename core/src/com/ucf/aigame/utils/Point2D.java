package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 */
public class Point2D
{
    private float x;
    private float y;

    //================================================================================================================//
    //                                               Constructors                                                     //
    //================================================================================================================//

    public Point2D()
    {

    }

    public Point2D(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    //================================================================================================================//
    //                                              Utility Methods                                                   //
    //================================================================================================================//

    public void printPoint()
    {
        System.out.println("(" + x + ", " + y + ")");
    }

    //================================================================================================================//
    //                                             Getters and Setters                                                //
    //================================================================================================================//

    public float getX()
    {
        return x;
    }

    public void setX( float x )
    {
        this.x = x;
    }

    public float getY()
    {
        return y;
    }

    public void setY( float y )
    {
        this.y = y;
    }

    public void setPoint( float x, float y)
    {
        this.x = x;
        this.y = y;
    }
}
