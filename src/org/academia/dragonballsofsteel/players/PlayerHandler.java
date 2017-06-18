package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

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

    void setSkin(boolean direction);

    void setPos(int x, int y, boolean direction);

    void setColisonCheker(PlayerColissionChecker cheker);

    void clean();

}
