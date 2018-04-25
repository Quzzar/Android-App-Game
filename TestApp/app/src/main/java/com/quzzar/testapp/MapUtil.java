package com.quzzar.testapp;

import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.RectF;

import com.quzzar.testapp.MapGeometry.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class MapUtil{

    public static ArrayList<Point> findNearestPoints(int amount, Point basePoint, ArrayList<Point> totalPoints){

        ArrayList<Line> linesToPoints = new ArrayList<>();

        for(Point point : totalPoints){
            if(!point.equals(basePoint)){
                linesToPoints.add(new Line(basePoint,point));
            }
        }

        Collections.sort(linesToPoints, new Comparator<Line>(){
            public int compare(Line o1, Line o2){
                return (int) (o1.length() - o2.length());
            }
        });

        ArrayList<Point> nearestPoints = new ArrayList<>();

        if(linesToPoints.size()>amount){
            for(int i = 0; i < amount; i++){
                nearestPoints.add(linesToPoints.get(i).getPointB());
            }
        }

        return nearestPoints;
    }


    public static Point getCenterOfPath(Path path){
        RectF bounds = new RectF();
        path.computeBounds(bounds, false); // fills rect with bounds
        PointF floatPoint = new PointF((bounds.left + bounds.right) / 2, (bounds.top + bounds.bottom) / 2);
        return new Point((int)floatPoint.x, (int)floatPoint.y);
    }

    public static int randomColor(){
        Random rand = new Random();
        return Color.rgb(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
    }

}
