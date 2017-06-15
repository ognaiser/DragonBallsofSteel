package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.SkinType;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Handles Player 1 keyboard keys
 */

public class PlayerOneHandler implements KeyboardHandler {

    private Picture image;
    private int speed;
    private SkinType skin;

    public PlayerOneHandler(int posx, int posy, int speed) {

        //Inicialize Properties
        image = new Picture(posx, posy, SkinType.VegetaFrenteEsquerda.getPath());
        image.draw();
        this.speed = speed;
        this.skin = SkinType.VegetaFrenteEsquerda;

        //Inicialize Key Events

        KeyboardEvent w = new KeyboardEvent();
        w.setKey(KeyboardEvent.KEY_W);
        w.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_A);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent d = new KeyboardEvent();
        d.setKey(KeyboardEvent.KEY_D);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        //Inicialize Keyboard
        Keyboard k = new Keyboard(this);

        k.addEventListener(w);
        k.addEventListener(a);
        k.addEventListener(s);
        k.addEventListener(d);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (checkBounderies(keyboardEvent)) {
                    image.translate(0, -speed);
                }
                break;
            case KeyboardEvent.KEY_A:
                if (checkBounderies(keyboardEvent)) {
                    image.translate(-speed, 0);
                }
                break;
            case KeyboardEvent.KEY_S:
                if (checkBounderies(keyboardEvent)) {
                    image.translate(0, speed);
                }
                break;
            case KeyboardEvent.KEY_D:
                if (checkBounderies(keyboardEvent)) {
                    image.translate(speed, 0);
                }
                break;

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }


    private boolean checkBounderies(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (image.getY() - speed < 0){
                    return false;
                }
                break;
            case KeyboardEvent.KEY_A:
                if (image.getX() - speed < 0){
                    return false;
                }
                break;
            case KeyboardEvent.KEY_S:
                if (image.getY() + speed > 300){
                    return false;
                }
                break;
            case KeyboardEvent.KEY_D:
                if (image.getX() + speed > 760){
                    return false;
                }
                break;
        }

        return true;
    }

    public int getPosx() {
        return image.getX();
    }


    public int getPosy() {
        return image.getMaxY();
    }
}
