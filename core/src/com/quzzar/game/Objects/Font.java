package com.quzzar.game.Objects;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.Input;

public class Font {

    private BitmapFont font;

    private float scale;

    public Font(FontType fontType, float scale){

        this.scale = scale;

        font = fontType.getFont();
        font.getData().setScale(scale);

    }

    public void writeText(SpriteBatch batch, String text, Location location){
        font.draw(batch,text,Input.xScaleToX(location.getX()),Input.yScaleToY(location.getY()));
    }

    public void setColor(float red, float green, float blue, float alpha){
        font.setColor(red, green, blue, alpha);
    }

    public void dispose(){
        font.dispose();
    }

}
