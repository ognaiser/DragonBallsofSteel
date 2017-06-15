package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.SkinType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Handles Player 1 keyboard keys
 */

public class PlayerOneHandler implements KeyboardHandler {

    private Picture image;
    private int posx;
    private int posy;

    public PlayerOneHandler(int posx, int posy) {
        image = new Picture(posx,posy, SkinType.VegetaFrente.getPath());
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
