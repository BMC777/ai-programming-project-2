package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 */
public class Vector2D
{
    private Point2D vectorPoint;
    private float vectorMagnitude;

    public Vector2D()
    {

    }

    public Vector2D( Point2D directionPoint )
    {
        this.vectorPoint = directionPoint;
        vectorMagnitude = (float)Math.sqrt( Math.pow(getX(), 2) + Math.pow(getY(), 2) );
    }



    public float getX()
    {
        return vectorPoint.getX();
    }

    public void setX( float x )
    {
        vectorPoint.setX( x );
    }

    public float getY()
    {
        return vectorPoint.getY();
    }

    public void setY( float y )
    {
        vectorPoint.setY( y );
    }

    public Point2D getPoint()
    {
        return vectorPoint;
    }

    public void setVector(float x, float y)
    {
        vectorPoint.setX( x );
        vectorPoint.setY( y );
    }


    public float getMagnitude()
    {
        return vectorMagnitude;
    }

    public void normalize()
    {
        float normalizedX = getX() / vectorMagnitude;
        float normalizedY = getY() / vectorMagnitude;

        setVector( normalizedX, normalizedY );
    }

    public boolean isUnitVector()
    {
        if ( Float.compare(vectorMagnitude, 1) == 0 )
        {
            return true;
        }

        return false;
    }

    public float dotProduct( Vector2D vector )
    {
        return vectorPoint.getX() * vector.getX() + vectorPoint.getY() * vector.getY();
    }

    public float dotProduct( float magnitude, float angleDegrees )
    {
        return (float)(vectorMagnitude * magnitude * Math.cos( angleDegrees * 180 / Math.PI ) );
    }

    public boolean isOrthogonalTo( Vector2D vector )
    {
        if ( dotProduct( vector ) == 0)
        {
            return true;
        }

        return false;
    }

    public float angularOffsetDegrees( Vector2D vector )
    {
        return (float)(Math.acos( dotProduct( vector ) / vectorMagnitude / vector.getMagnitude() ) * Math.PI / 180);
    }
}
