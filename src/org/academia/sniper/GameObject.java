package org.academia.sniper;

public abstract class GameObject implements Clickable {

    private boolean isCliked = false;
    private int posx ;
    private int posy ;

    public GameObject(int x, int y) {
        this.posx = x;
        this.posy = y;
    }


    public boolean isCLiked() {
        return isCliked;
    }

    public void setCliked() {
        isCliked = true;
    }


    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
}
