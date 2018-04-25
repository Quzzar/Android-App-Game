package com.quzzar.testapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;

import com.quzzar.testapp.MapGeometry.Polygon;

import java.util.ArrayList;
import java.util.Random;

public class MapGeneration implements GameObject{

    private ArrayList<Point> points = new ArrayList<Point>();

    private ArrayList<Point> centerPoints = new ArrayList<>();

    private ArrayList<Polygon> polygons = new ArrayList<Polygon>();



    public void generateMap(){

        points.clear(); polygons.clear();

        Random rand = new Random();

        for(int i = 0; i<=MainActivity.SCREEN_WIDTH; i++){
            for(int j = 0; j<=MainActivity.SCREEN_HEIGHT; j++){

                int r = rand.nextInt(100000);

                if(r==100){
                    points.add(new Point(i,j));
                }

            }
        }
        Log.d("DEBUG-1","Points Created: "+points.size());


        // Create triangles
        for (Point point : points){
            ArrayList<Point> nearestPoints = MapUtil.findNearestPoints(2, point, points);
            nearestPoints.add(point);

            Polygon polyTriangle = new Polygon(nearestPoints);

            centerPoints.add(MapUtil.getCenterOfPath(polyTriangle.getPath()));
        }

        // Create polygons
        for(Point centerPoint : centerPoints){
            ArrayList<Point> nearestPoints = MapUtil.findNearestPoints(4, centerPoint, centerPoints);
            nearestPoints.add(centerPoint);

            Polygon poly = new Polygon(nearestPoints);
            polygons.add(poly);

        }

        Log.d("DEBUG-2","Polygons Created: "+polygons.size());

        Paint paint1 = new Paint();
        paint1.setColor(Color.RED);

        Paint paint2 = new Paint();

        Paint paint3 = new Paint();
        paint3.setColor(Color.GREEN);


        for(Polygon polygon : polygons){

            paint2.setColor(MapUtil.randomColor());

            Graphics.getCanvas().drawPath(polygon.getPath(),paint2);
        }

        for(Point point : points){
            Graphics.getCanvas().drawCircle(point.x,point.y,5,paint1);
        }

        for(Point centerPoint : centerPoints){
            Graphics.getCanvas().drawCircle(centerPoint.x,centerPoint.y,5,paint3);
        }

    }

    @Override
    public void update() {

    }



}
