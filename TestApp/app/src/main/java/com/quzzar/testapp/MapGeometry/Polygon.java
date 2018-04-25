package com.quzzar.testapp.MapGeometry;

import android.graphics.Path;
import android.graphics.Point;

import java.util.ArrayList;

public class Polygon {

    private ArrayList<Point> points;
    private Path path;

    public Polygon(ArrayList<Point> points) {

        this.points = points;

        path = new Path();

        path.moveTo(points.get(0).x,points.get(0).y);
        for (Point p : points){
            path.lineTo(p.x,p.y);
        }
        path.lineTo(points.get(0).x,points.get(0).y);

    }

    public ArrayList<Point> getPoints(){
        return points;
    }

    public Path getPath(){
        return path;
    }



}
