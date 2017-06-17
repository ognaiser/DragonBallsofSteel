package org.academia.sniper;

public abstract class GameObjects implements Clickable {

    private int timeLeft;

    public GameObjects(int timeLeft) {
        this.timeLeft = timeLeft;
    }

    public void countDown(int time){
        timeLeft-= time;
    }

}
