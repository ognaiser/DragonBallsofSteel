package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Handles Player 1 keyboard keys
 */

public class PlayerOneHandler implements KeyboardHandler, PlayerHandler {

    private Picture image;
    private int speed;
    private SkinTypeVegeta skin;
    private boolean isAirBorn = false;
    private Player player;
    private boolean isRight = true;
    private PlayerColissionChecker checker;

    public PlayerOneHandler(int speed, Player player) {

        //Inicialize Properties
        image = new Picture(660, 290, SkinTypeVegeta.VegetaStartLeft.getPath());
        image.draw();
        this.speed = speed;
        this.skin = SkinTypeVegeta.VegetaStartLeft;
        this.player = player;

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

        KeyboardEvent qPressed = new KeyboardEvent();
        qPressed.setKey(KeyboardEvent.KEY_Q);
        qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent qReleased = new KeyboardEvent();
        qReleased.setKey(KeyboardEvent.KEY_Q);
        qReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent ePressed = new KeyboardEvent();
        ePressed.setKey(KeyboardEvent.KEY_E);
        ePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent eReleased = new KeyboardEvent();
        eReleased.setKey(KeyboardEvent.KEY_E);
        eReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        //Inicialize Keyboard
        Keyboard k = new Keyboard(this);

        //Movement Keys event Add
        k.addEventListener(w);
        k.addEventListener(a);
        k.addEventListener(s);
        k.addEventListener(d);

        //punch Key Add
        k.addEventListener(qPressed);
        k.addEventListener(qReleased);

        //Def Key Add
        k.addEventListener(ePressed);
        k.addEventListener(eReleased);

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (checkBounderies(keyboardEvent)) {
                    if (isRight) {
                        image.load(SkinTypeVegeta.VegetaFlyLeft.getPath());
                        isAirBorn = true;
                    } else {
                        image.load(SkinTypeVegeta.VegetaFlyRight.getPath());
                        isAirBorn = true;
                    }
                    image.translate(0, -speed);
                }
                break;

            case KeyboardEvent.KEY_A:

                if (checkBounderies(keyboardEvent)) {

                    if (image.getX() < checker.getPlayerTwoX()) {
                        isRight = false;
                    } else {
                        isRight = true;
                    }

                    image.translate(-speed, 0);

                    sideMoveSkinSetter();

                }
                break;

            case KeyboardEvent.KEY_S:
                if (checkBounderies(keyboardEvent)) {
                    if (isRight) {
                        image.translate(0, speed);
                        if (!checkBounderies(keyboardEvent)) {
                            isAirBorn = false;
                            image.load(SkinTypeVegeta.VegetaGroundLeft.getPath());
                        } else {
                            image.load(SkinTypeVegeta.VegetaFlyLeft.getPath());
                        }
                    } else {
                        image.translate(0, speed);
                        if (!checkBounderies(keyboardEvent)) {
                            isAirBorn = false;
                            image.load(SkinTypeVegeta.VegetaGroundRight.getPath());
                        } else {
                            image.load(SkinTypeVegeta.VegetaFlyRight.getPath());
                        }

                    }
                }
                break;

            case KeyboardEvent.KEY_D:
                if (checkBounderies(keyboardEvent)) {

                    if (image.getX() > checker.getPlayerTwoX()) {
                        isRight = true;
                    } else {
                        isRight = false;
                    }

                    image.translate(speed, 0);

                    sideMoveSkinSetter();
                }

                break;

            case KeyboardEvent.KEY_Q:
                //TODO: Code for punch action
                if (isRight) {
                    image.load(SkinTypeVegeta.VegetaPunchLeft.getPath());
                } else {
                    image.load(SkinTypeVegeta.VegetaPunchRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_E:
                //TODO: Code for Deff
                break;

        }

    }

    private void sideMoveSkinSetter() {

        if (isRight) {
            if (isAirBorn) {
                image.load(SkinTypeVegeta.VegetaFlyLeft.getPath());
            } else {
                image.load(SkinTypeVegeta.VegetaGroundLeft.getPath());
            }
        } else {
            if (isAirBorn) {
                image.load(SkinTypeVegeta.VegetaFlyRight.getPath());
            } else {
                image.load(SkinTypeVegeta.VegetaGroundRight.getPath());
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                //TODO:COde for when punch ends
                    sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_E:
                //TODO: Code for when def ends
                break;
        }
    }


    private boolean checkBounderies(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (image.getY() - speed < 0) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_A:
                if (image.getX() - speed < 0) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_S:
                if (image.getY() + speed > 290) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_D:
                if (image.getX() + speed > 760) {
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
        return image.getY();
    }

    @Override
    public void setColisonCheker(PlayerColissionChecker cheker) {
        this.checker = cheker;
    }

}
