package com.quzzar.game.Player;

import com.quzzar.game.World.Area;
import com.quzzar.game.World.Map;
import com.quzzar.game.World.Region;

import java.io.Serializable;

public class MapLoc implements Serializable{

    private int regionIndex;
    private int areaIndex;

    public MapLoc(int regionIndex, int areaIndex){
        this.regionIndex = regionIndex;
        this.areaIndex = areaIndex;
    }

    public void setRegionIndex(int regionIndex) {
        this.regionIndex = regionIndex;
    }

    public void setAreaIndex(int areaIndex) {
        this.areaIndex = areaIndex;
    }

    public int getRegionIndex() {
        return regionIndex;
    }

    public int getAreaIndex() {
        return areaIndex;
    }

    public boolean isAt(int regionIndex, int areaIndex){
        return getRegionIndex()==regionIndex && getAreaIndex()==areaIndex;
    }

    public void set(int regionIndex, int areaIndex){
        this.regionIndex = regionIndex;
        this.areaIndex = areaIndex;
    }

    public Region getRegion(){
        return Map.getRegions().get(regionIndex);
    }

    public Area getArea(){
        return Map.getRegions().get(regionIndex).getAreas().get(areaIndex);
    }

}
