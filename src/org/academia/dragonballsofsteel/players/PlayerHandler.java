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

    /**
     * @return if any designated key of the handler is being pressed
     */
    boolean isKeyPressed();

    /**
     * set isKeyPressed to false
     */
    void setKeyPressed();

    /**
     * @return the direction on X Axis that an image is facing
     */
    boolean facingRight();

    /**
     * Changes the amount of pixels that a image can move
     * @param amount
     */
    void setSpeed(int amount);

    /**
     * Make an image move sequentially in a direction
     * @param xPos starting point
     * @param direction on X Axis
     * @throws InterruptedException
     */
    void moveInDirection(int xPos, boolean direction) throws InterruptedException;

    /**
     * Make image flip by changing to a mirror image
     * @param direction
     */
    void setSideSkin(boolean direction);

    /**
     * Make an image move sequentially on Y Axis
     * @param pic new image
     * @param y where it start
     * @throws InterruptedException
     */
    void setSkin(Picture pic, int y) throws InterruptedException;

    /**
     * Set a new position for the image
     * @param x
     * @param y
     * @param direction
     */
    void setPos(int x, int y, boolean direction);

    /**
     * Set a collision Checker for the image
     * @param cheker
     */
    void setColisonCheker(PlayerColissionChecker cheker);

    /**
     * Removes all key handlers and deletes the image
     */
    void clean();

}
