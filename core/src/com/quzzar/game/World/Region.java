package com.quzzar.game.World;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.quzzar.game.DataHandling.SaveData;
import com.quzzar.game.Input;
import com.quzzar.game.Objects.Line;
import com.quzzar.game.Player.Player;

import java.util.List;

public class Region {

    private List<Area> areas;
    private boolean[][] pathMatrix;
    private Texture regionTexture;

    public Region(String regionPath, List<Area> areas){

        this.areas = areas;
        this.pathMatrix = new boolean[areas.size()][areas.size()];
        this.regionTexture = new Texture(regionPath);

    }

    public void addPath(int areaIndexA, int areaIndexB){
        pathMatrix[areaIndexA][areaIndexB] = true;
        pathMatrix[areaIndexB][areaIndexA] = true;
    }

    public void drawAreas(SpriteBatch batch, Color currentAreaTint){

        for (Area area : areas) {
            if(area.equals(Player.getStats().getPlayerLocation().getArea())){
                batch.setColor(currentAreaTint);
                area.getImage().draw(batch);
                batch.setColor(Color.WHITE);
            } else {
                area.getImage().draw(batch);
            }
        }

    }

    public void drawPaths(ShapeRenderer renderer){

        for(int i=0; i<pathMatrix.length; i++) {
            for(int j=0; j<pathMatrix[i].length; j++) {
                if(hasPath(i,j)) {
                    Line line = new Line(areas.get(i).getImage().getLocation(),areas.get(j).getImage().getLocation());
                    line.draw(renderer,20f);
                }
            }
        }

    }

    public void handleAreasPressed(){

        int areaIndex = Player.getStats().getPlayerLocation().getAreaIndex();

        for (Area area : areas) {
            if(area.getImage().containsLocation(Input.getTouchedLocation())){

                /* Only move areas if the new area is adjacent */
                if(hasPath(areas.indexOf(area),areaIndex)){
                    Player.getStats().getPlayerLocation().setAreaIndex(areas.indexOf(area));
                    SaveData.save();
                }

                return;
            }
        }



    }

    public boolean hasPath(int areaIndexA, int areaIndexB){
        return pathMatrix[areaIndexA][areaIndexB];
    }

    public List<Area> getAreas() {
        return areas;
    }

    public Texture getRegionTexture() {
        return regionTexture;
    }

}
