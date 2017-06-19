package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public interface PlayerHandler {

    int getPosx();

    int getPosy();

    int getWidth();

    int getHeight();

    int getSpeed();

    KeyboardEvent getLastKey();

    KeyboardEvent getPreviousKey();

    boolean isKeyPressed();

    void setKeyPressed();

    boolean facingRight();

    void setSpeed(int amount);

    void moveInDirection(int xPos, boolean direction) throws InterruptedException;

    void setSideSkin(boolean direction);

    void setSkin(Picture pic, int y) throws InterruptedException;

    void setPos(int x, int y, boolean direction);

    void setColisonCheker(PlayerColissionChecker cheker);

    void clean();

}
