package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public interface PlayerHandler {

    int getPosx();

    int getPosy();

    int getWith();

    int getHeight();

    int getSpeed();

    KeyboardEvent getLastKey();

    KeyboardEvent getPreviousKey();

    boolean isKeyPressed();

    void setKeyPressed();

    void setPos(int x, int y);

    void setColisonCheker(PlayerColissionChecker cheker);

}
