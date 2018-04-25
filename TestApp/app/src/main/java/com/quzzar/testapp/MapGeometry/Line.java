package com.quzzar.testapp.MapGeometry;

import android.graphics.Point;
import android.support.annotation.NonNull;

public class Line{

    private Point pointA;
    private Point pointB;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA(){
        return pointA;
    }

    public Point getPointB(){
        return pointB;
    }

    public double length(){
        return Math.sqrt(Math.pow(pointB.y-pointA.y, 2) + Math.pow(pointB.x-pointA.x, 2));
    }

}
