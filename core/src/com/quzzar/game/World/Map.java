package com.quzzar.game.World;

import com.quzzar.game.Player.MapLoc;
import com.quzzar.game.Player.Player;

import java.util.Arrays;
import java.util.List;

public class Map {

    private static List<Region> regions;

    public static void initialize(){

        // xScale shouldn't pass ~0.7

        Region region_0 = new Region("game/map/regions/region_0.png",Arrays.asList(new Area(0.2,0.2),
                new Area(0.3,0.4), new Area(0.65,0.5), new Area(0.5,0.2),
                new Area(0.6,0.05,true)));

        region_0.addPath(0,1);
        region_0.addPath(1,2);
        region_0.addPath(0,3);
        region_0.addPath(1,3);
        region_0.addPath(3,4);

        Region region_1 = new Region("game/map/regions/region_1.png",Arrays.asList(new Area(0.2,0.3),
                new Area(0.1,0.6), new Area(0.65,0.3), new Area(0.5,0.2)));

        region_1.addPath(2,3);
        region_1.addPath(1,2);
        region_1.addPath(0,3);
        region_1.addPath(1,3);

        Region region_2 = new Region("game/map/regions/region_2.png",Arrays.asList(new Area(0.5,0.4),
                new Area(0.4,0.6), new Area(0.1,0.2)));

        region_2.addPath(0,2);
        region_2.addPath(1,2);

        Region region_3 = new Region("game/map/regions/region_3.png",Arrays.asList(new Area(0.2,0.6),
                new Area(0.4,0.9), new Area(0.3,0.5), new Area(0.1,0.3), new Area(0.2,0.3)));

        region_3.addPath(2,3);
        region_3.addPath(1,2);
        region_3.addPath(0,3);
        region_3.addPath(1,3);
        region_3.addPath(1,4);

        regions = Arrays.asList(region_0,region_1,region_2,region_3);

    }

    public static List<Region> getRegions() {
        return regions;
    }


    public static boolean checkForRegionChange(){

        MapLoc mapLoc = Player.getStats().getPlayerLocation();
        if(mapLoc.getArea().isExit()){

            if(mapLoc.isAt(0,4)){
                mapLoc.set(1,1);
                return true;
            }

        }
        return false;
    }

}
