package org.academia.sniper;

public abstract class GameObject implements Clickable {

    private int timeLeft;

    public GameObject(int timeLeft) {
        this.timeLeft = timeLeft;
    }


    public void countDown(int time){
        timeLeft-= time;
    }

}
