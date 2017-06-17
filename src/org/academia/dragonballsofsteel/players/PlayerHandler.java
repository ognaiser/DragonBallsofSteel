package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;

public interface PlayerHandler {

    int getPosx();

    int getPosy();

    int getWith();

    int getHeight();

    int getSpeed();

    KeyboardEvent getLastKey();

    void setColisonCheker(PlayerColissionChecker cheker);

}
