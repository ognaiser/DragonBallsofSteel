package org.academia.dragonballsofsteel.players;

import org.academia.dragonballsofsteel.Game;
import org.academia.dragonballsofsteel.SkinTypeGoku;
import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Handles Player 2 keyboard keys
 */

public class PlayerTwoHandler implements KeyboardHandler, PlayerHandler{

    private Picture image;
    private int speed;
    private SkinTypeGoku skin;
    private boolean isAirBorn = false;
    private Player player;
    private PlayerColissionChecker checker;
    private boolean isRight = false;
    private KeyboardEvent lastKey;
    private KeyboardEvent previousKey;
    private boolean isKeyPressed = false;

    public PlayerTwoHandler(int speed, Player player) {

        //Inicialize Properties
        image = new Picture(885, Game.bottomBounderi, SkinTypeGoku.GokuStartLeft.getPath());
        image.draw();
        this.speed = speed;
        this.skin = SkinTypeGoku.GokuStartRight;
        this.player = player;
        lastKey = new KeyboardEvent();
        previousKey = new KeyboardEvent();

        //Inicialize Key Events

        KeyboardEvent w = new KeyboardEvent();
        w.setKey(KeyboardEvent.KEY_UP);
        w.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_LEFT);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_DOWN);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent d = new KeyboardEvent();
        d.setKey(KeyboardEvent.KEY_RIGHT);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent kPressed = new KeyboardEvent();
        kPressed.setKey(KeyboardEvent.KEY_K);
        kPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent kReleased = new KeyboardEvent();
        kReleased.setKey(KeyboardEvent.KEY_K);
        kReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent lPressed = new KeyboardEvent();
        lPressed.setKey(KeyboardEvent.KEY_L);
        lPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent lReleased = new KeyboardEvent();
        lReleased.setKey(KeyboardEvent.KEY_L);
        lReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent pPressed = new KeyboardEvent();
        pPressed.setKey(KeyboardEvent.KEY_P);
        pPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent pReleased = new KeyboardEvent();
        pReleased.setKey(KeyboardEvent.KEY_P);
        pReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        KeyboardEvent oPressed = new KeyboardEvent();
        oPressed.setKey(KeyboardEvent.KEY_O);
        oPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent oReleased = new KeyboardEvent();
        oReleased.setKey(KeyboardEvent.KEY_O);
        oReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        //Inicialize Keyboard
        Keyboard k = new Keyboard(this);

        //Movement Keys event Add
        k.addEventListener(w);
        k.addEventListener(a);
        k.addEventListener(s);
        k.addEventListener(d);

        //punch Key Add
        k.addEventListener(kPressed);
        k.addEventListener(kReleased);

        //Def Key Add
        k.addEventListener(lPressed);
        k.addEventListener(lReleased);
        /*
        //Kick Key Add
        k.addEventListener(pPressed);
        k.addEventListener(pReleased);

        //Burst Key Add
        k.addEventListener(oPressed);
        k.addEventListener(oReleased);
         */

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        previousKey = lastKey;
        lastKey = keyboardEvent;
        isKeyPressed = true;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (checkBounderies(keyboardEvent)) {
                    if (isRight) {
                        image.load(SkinTypeGoku.GokuFlyLeft.getPath());
                        isAirBorn = true;
                    } else {
                        image.load(SkinTypeGoku.GokuFlyRight.getPath());
                        isAirBorn = true;
                    }
                    image.translate(0, -speed);
                }
                break;

            case KeyboardEvent.KEY_LEFT:

                if (checkBounderies(keyboardEvent)) {

                    if (image.getX() < checker.getPlayerOneX()) {
                        isRight = false;
                    } else {
                        isRight = true;
                    }

                    image.translate(-speed, 0);

                    sideMoveSkinSetter();

                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if (checkBounderies(keyboardEvent)) {
                    if (isRight) {
                        image.translate(0, speed);
                        if (!checkBounderies(keyboardEvent)) {
                            isAirBorn = false;
                            image.load(SkinTypeGoku.GokuGroundLeft.getPath());
                        } else {
                            image.load(SkinTypeGoku.GokuFlyLeft.getPath());
                        }
                    } else {
                        image.translate(0, speed);
                        if (!checkBounderies(keyboardEvent)) {
                            isAirBorn = false;
                            image.load(SkinTypeGoku.GokuGroundRight.getPath());
                        } else {
                            image.load(SkinTypeGoku.GokuFlyRight.getPath());
                        }
                    }
                }
                break;

            case KeyboardEvent.KEY_RIGHT:

                if (checkBounderies(keyboardEvent)) {

                    if (image.getX() > checker.getPlayerOneX()) {
                        isRight = true;
                    } else {
                        isRight = false;
                    }

                    image.translate(speed, 0);

                    sideMoveSkinSetter();
                }

                break;

            case KeyboardEvent.KEY_K:
                //TODO: Code for punch action
                if (isRight) {
                    image.load(SkinTypeGoku.GokuPunchLeft.getPath());
                } else {
                    image.load(SkinTypeGoku.GokuPunchRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_L:
                //TODO: Code for Deff
                if (isRight){
                    image.load(SkinTypeGoku.GokuDefLeft.getPath());
                }else {
                    image.load(SkinTypeGoku.GokuDefRight.getPath());
                }
                break;/*
            case KeyboardEvent.KEY_P:
                //TODO: Code for Kick
                if (isRight){
                    image.load(SkinTypeGoku);
                }else {
                    image.load(SkinTypeGoku);
                }
                break;
            case KeyboardEvent.KEY_O:
                //TODO: Code for BurstEnergy
                image.load(SkinTypeGoku.Goku);
                break;*/
        }

    }

    private void sideMoveSkinSetter() {

        if (isRight) {
            if (isAirBorn) {
                image.load(SkinTypeGoku.GokuFlyLeft.getPath());
            } else {
                image.load(SkinTypeGoku.GokuGroundLeft.getPath());
            }
        } else {
            if (isAirBorn) {
                image.load(SkinTypeGoku.GokuFlyRight.getPath());
            } else {
                image.load(SkinTypeGoku.GokuGroundRight.getPath());
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_K:
                //TODO:COde for when punch ends
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_L:
                //TODO: Code for when def ends
                sideMoveSkinSetter();
                break;
/*
            case KeyboardEvent.KEY_P:
                //TODO: Code for when kick ends
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_O:
                //TODO: Code for when burst ends
                sideMoveSkinSetter();
                break;*/
        }
    }


    private boolean checkBounderies(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_UP:
                if (image.getY() - speed < Game.topBonderi) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_LEFT:
                if (image.getX() - speed < Game.leftBonderi) {
                    return false;
                }
                if (checker.checkPlayerCollision(keyboardEvent)){
                    return false;
                }
                break;
            case KeyboardEvent.KEY_DOWN:
                if (image.getY() + speed > Game.bottomBounderi) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (image.getX() + speed > Game.rightBounderi) {
                    return false;
                }
                if (checker.checkPlayerCollision(keyboardEvent)){
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
    public int getWith() {
        return image.getWidth();
    }

    @Override
    public int getHeight() {
        return image.getHeight();
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public KeyboardEvent getLastKey() {
        return lastKey;
    }

    @Override
    public boolean isKeyPressed() {
        return isKeyPressed;
    }

    @Override
    public void setKeyPressed() {
        isKeyPressed = false;
    }

    public KeyboardEvent getPreviousKey() {
        return previousKey;
    }

    public void setPos(int x, int y){
        image.delete();
        image = new Picture(x, y, SkinTypeVegeta.VegetaFlyLeft.getPath());
        sideMoveSkinSetter();
        image.draw();
    }

    @Override
    public void setColisonCheker(PlayerColissionChecker cheker) {
        this.checker = cheker;
    }
}
