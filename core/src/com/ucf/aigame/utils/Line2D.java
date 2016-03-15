package com.ucf.aigame.utils;

/**
 * Created by Bryan on 3/13/2016.
 *
 * Line Object contains Point2D point1, Point2D point2, float slope, float yIntercept.
 */
public class Line2D
{
    private Point2D point1;
    private Point2D point2;

    private float slope;
    private float yIntercept;

    //================================================================================================================//
    //                                               Constructors                                                     //
    //================================================================================================================//

    public Line2D()
    {

    }

    public Line2D( LineSegment2D lineSegment )
    {
        point1 = lineSegment.getOriginPoint();
        point2 = lineSegment.getEndPoint();

        slope = calculateSlope();
        yIntercept = calculateYIntercept();
    }

    public Line2D(Point2D point1, Point2D point2 )
    {
        this.point1 = point1;
        this.point2 = point2;

        slope = calculateSlope();
        yIntercept = calculateYIntercept();
    }

    //================================================================================================================//
    //                                              Utility Methods                                                   //
    //================================================================================================================//

    public void printSlopeInterceptForm()
    {
        System.out.println("y = " + slope + " x + " + yIntercept);
    }

    //================================================================================================================//
    //                                             Getters and Setters                                                //
    //================================================================================================================//
    public LineSegment2D getLineSegmentFromLine()
    {
        return new LineSegment2D(point1, point2);
    }

    public void setLineFromLineSegment( LineSegment2D lineSegment )
    {
        point1 = lineSegment.getOriginPoint();
        point2 = lineSegment.getEndPoint();

        slope = calculateSlope();
        yIntercept = calculateYIntercept();
    }

    public Point2D getPoint1()
    {
        return point1;
    }

    public void setPoint1( Point2D point1 )
    {
        this.point1 = point1;

        slope = calculateSlope();
        yIntercept = calculateYIntercept();
    }

    public Point2D getPoint2()
    {
        return point2;
    }

    public void setPoint2( Point2D point2 )
    {
        this.point2 = point2;

        slope = calculateSlope();
        yIntercept = calculateYIntercept();
    }

    public float getSlope()
    {
        return slope;
    }

    public float getYIntercept()
    {
        return yIntercept;
    }

    //================================================================================================================//
    //                                              Private Methods                                                   //
    //================================================================================================================//

    private float calculateSlope()
    {
        return ( point1.getY() - point2.getY() ) / ( point1.getX() - point2.getX() ); // m = (y2 - y1) / (x2 - x1)
    }

    private float calculateYIntercept()
    {
        return point1.getY() - ( slope * point1.getX() ); // y - mx = b
    }






}
