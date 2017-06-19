package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Interface that can be implemented on a keyboard handler
 */
public interface PlayerHandler {

    /**
     * @return the position of an image on X Axis
     */
    int getPosx();

    /**
     * @return the position of an image on Y Axis
     */
    int getPosy();

    /**
     * @return the width of an image
     */
    int getWidth();

    /**
     * @return the height of an image
     */
    int getHeight();

    /**
     * @return the amount of pixels that an image can move
     */
    int getSpeed();

    /**
     * @return the last key pressed
     */
    KeyboardEvent getLastKey();

    /**
     * @return the previous key pressed
     */
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
