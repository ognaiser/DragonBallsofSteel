package org.academia.sniper;

public abstract class GameObjects implements Clickable {

    private int timeLeft;

    public void countDown(int time){
        timeLeft-= time;
    }

}
