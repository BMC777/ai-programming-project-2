package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 */
public class Intersection
{
    //================================================================================================================//
    //                                              Utility Methods                                                   //
    //================================================================================================================//

    public Point2D getIntersectionPoint(LineSegment2D lineSegment1, LineSegment2D lineSegment2) throws ArithmeticException
    {
        Line2D line1 = new Line2D(lineSegment1);
        Line2D line2 = new Line2D(lineSegment2);

        if ( line1.getSlope() == line2.getSlope() )
        {
            //Same slope and intercept means segments exist on the same line.
            if ( line1.getYIntercept() == line2.getYIntercept() )
            {
                throw new ArithmeticException("Segments of the same Line!");
            }

            throw new ArithmeticException("Parallel Segments!");
        }

        Point2D intersectionPoint = new Point2D();

        // m1x + b1 = m2x + b2 --> (m1 - m2)x = (b2 - b1) --> x = (b2 - b1) / (m1 - m2)
        intersectionPoint.setX( ( line2.getYIntercept() - line1.getYIntercept() ) / ( line1.getSlope() - line2.getSlope() ) );

        // y = mx + b
        intersectionPoint.setY( line1.getSlope() * intersectionPoint.getX() + line1.getYIntercept() );

        //Check if found intersectionPoint resides on both segments.
        if ( !lineSegment1.checkPoint(intersectionPoint) || !lineSegment2.checkPoint(intersectionPoint) )
        {
            throw new ArithmeticException("No Intersection!");
        }

        return intersectionPoint;
    }
}
