package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 */
public class Rectangle
{
    LineSegment2D side1;
    LineSegment2D side2;
    LineSegment2D side3;
    LineSegment2D side4;

    //================================================================================================================//
    //                                               Constructors                                                     //
    //================================================================================================================//

    public Rectangle()
    {

    }

    public Rectangle(Point2D point1, Point2D point2)
    {
        side1 = new LineSegment2D( point1, new Point2D(point1.getX(), point2.getY() ) );
        side2 = new LineSegment2D( point1, new Point2D(point2.getX(), point1.getY() ) );
        side3 = new LineSegment2D( point2, new Point2D(point1.getX(), point2.getY() ) );
        side4 = new LineSegment2D( point2, new Point2D(point2.getX(), point1.getY() ) );
    }
}
