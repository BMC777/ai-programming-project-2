package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 * Line Segment Object contains Point2D originPoint, Point2D endPoint, float slope, float length.
 */
public class LineSegment2D
{
    private Point2D originPoint;
    private Point2D endPoint;

    private float slope;
    private float length;

    //================================================================================================================//
    //                                               Constructors                                                     //
    //================================================================================================================//
    public LineSegment2D()
    {

    }

    public LineSegment2D(Point2D originPoint, Point2D endPoint)
    {
        this.originPoint = originPoint;
        this.endPoint = endPoint;

        slope = calculateSlope();
        length = calculateLength();
    }

    //Check if a point exists on line segment.
    public boolean checkPoint( Point2D point )
    {
        LineSegment2D subSegment1 = new LineSegment2D(originPoint, point);
        LineSegment2D subSegment2 = new LineSegment2D(point, endPoint);

        if ( Float.compare(subSegment1.getLength() + subSegment2.getLength(), length) == 0 )
        {
            return true;
        }

        return false;
    }

    //================================================================================================================//
    //                                             Getters and Setters                                                //
    //================================================================================================================//

    public Point2D getOriginPoint()
    {
        return originPoint;
    }

    public void setOriginPoint(Point2D originPoint)
    {
        this.originPoint = originPoint;
    }

    public Point2D getEndPoint()
    {
        return endPoint;
    }

    public void setEndPoint(Point2D endPoint)
    {
        this.endPoint = endPoint;
    }

    public float getLength()
    {
        return length;
    }

    public float getSlope()
    {
        return slope;
    }

    public void setLineSegment( Point2D originPoint, Point2D endPoint )
    {
        this.originPoint = originPoint;
        this.endPoint = endPoint;
    }

    //================================================================================================================//
    //                                              Private Methods                                                   //
    //================================================================================================================//

    private float calculateLength()
    {
        return (float)Math.sqrt( Math.pow( endPoint.getX() - originPoint.getX(), 2 )
                + Math.pow( endPoint.getY() - originPoint.getY(), 2 ) );
    }

    private float calculateSlope()
    {
        return ( endPoint.getY() - originPoint.getY() ) / ( endPoint.getX() - originPoint.getX() );
    }
}
