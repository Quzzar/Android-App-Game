package com.quzzar.game.Display;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.quzzar.game.Fonts.FontType;
import com.quzzar.game.Objects.Font;
import com.quzzar.game.Objects.Location;

public class Announcement {

    private String text = "";
    final private int maxDuration;
    private int duration;
    private Font font = new Font(FontType.AK_SANS,4f);

    private State state = State.READY;

    public Announcement(String text, int duration){

        this.text = text;
        this.duration = duration;
        this.maxDuration = duration;
    }

    public Announcement(int duration){

        this.duration = duration;
        this.maxDuration = duration;
    }

    public void setText(String text){
        this.text = text;
    }

    public void run(SpriteBatch batch){
        if(duration>0){
            this.state = State.RUNNING;
            duration--;
            font.setColor(1.0f, 1.0f, 1.0f, duration*1.0f/maxDuration);

            font.writeText(batch,text,new Location(0.4,0.5));

        } else {
            this.state = State.FINISHED;
            font.dispose();
        }
    }

    public boolean isFinished(){
        return state.equals(State.FINISHED);
    }

    public boolean isReady(){
        return state.equals(State.READY);
    }

    public boolean isRunning(){
        return state.equals(State.RUNNING);
    }

}

enum State{

    READY,
    FINISHED,
    RUNNING

}
