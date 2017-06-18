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
 * Handles Player 1 keyboard keys
 */

public class PlayerOneHandler implements KeyboardHandler, PlayerHandler {

    /**
     * Each handler has a:
     * -Image (Picture)
     * -Speed (int)
     * -Skin (SkinTypeVegeta)
     * -AirBorn State (Boolean)
     * -Player (Player)
     * -Is in Right side state (Boolean)
     * -Collision Checker (ColissionChecker)
     */

    private Picture image;
    private int speed;
    private SkinTypeVegeta skin;
    private boolean isAirBorn = false;
    private Player player;
    private boolean isRight = true;
    private PlayerColissionChecker checker;
    private KeyboardEvent lastKey;
    private KeyboardEvent previousKey;
    private boolean isKeyPressed = false;
    private Keyboard k;
    //Events
    private KeyboardEvent fReleased;
    private KeyboardEvent w;
    private KeyboardEvent a;
    private KeyboardEvent s;
    private KeyboardEvent d;
    private KeyboardEvent qPressed;
    private KeyboardEvent qReleased;
    private KeyboardEvent ePressed;
    private KeyboardEvent eReleased;
    private KeyboardEvent fPressed;
    private KeyboardEvent xPressed;
    private KeyboardEvent xReleased;


    /**
     *
     * Constructer for Player 1
     *
     * @param speed
     * @param player
     */

    public PlayerOneHandler(int speed, Player player) {

        //Inicialize Properties
        image = new Picture(397, Game.bottomBounderi, SkinTypeVegeta.VegetaStartRight.getPath());
        image.draw();
        this.speed = speed;
        this.skin = SkinTypeVegeta.VegetaStartLeft;
        this.player = player;
        lastKey = new KeyboardEvent();
        previousKey = new KeyboardEvent();

        //Inicialize Key Events

        w = new KeyboardEvent();
        w.setKey(KeyboardEvent.KEY_W);
        w.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_A);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        d = new KeyboardEvent();
        d.setKey(KeyboardEvent.KEY_D);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        qPressed = new KeyboardEvent();
        qPressed.setKey(KeyboardEvent.KEY_Q);
        qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        qReleased = new KeyboardEvent();
        qReleased.setKey(KeyboardEvent.KEY_Q);
        qReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        ePressed = new KeyboardEvent();
        ePressed.setKey(KeyboardEvent.KEY_E);
        ePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        eReleased = new KeyboardEvent();
        eReleased.setKey(KeyboardEvent.KEY_E);
        eReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        fPressed = new KeyboardEvent();
        fPressed.setKey(KeyboardEvent.KEY_F);
        fPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        fReleased = new KeyboardEvent();
        fReleased.setKey(KeyboardEvent.KEY_F);
        fReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        xPressed = new KeyboardEvent();
        xPressed.setKey(KeyboardEvent.KEY_X);
        xPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        xReleased = new KeyboardEvent();
        xReleased.setKey(KeyboardEvent.KEY_X);
        xReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        //Inicialize Keyboard
        k = new Keyboard(this);

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

        //kick Key Add
        k.addEventListener(xPressed);
        k.addEventListener(xReleased);

        //burstEnergy Key Add
        k.addEventListener(fPressed);
        k.addEventListener(fReleased);



    }

    /**
     * KeyPressedEvents
     *
     * @param keyboardEvent
     */
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        previousKey = lastKey;
        lastKey = keyboardEvent;
        isKeyPressed = true;
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
                if (isRight) {
                    image.load(SkinTypeVegeta.VegetaDefLeft.getPath());
                } else {
                    image.load(SkinTypeVegeta.VegetaDefRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_X:
                //TODO: Code for Kick
                if (isRight) {
                    image.load(SkinTypeVegeta.VegetaKickLeft.getPath());
                } else {
                    image.load(SkinTypeVegeta.VegetaKickRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_F:
                //TODO: Code for Burst
                image.load(SkinTypeVegeta.VegetaCharge.getPath());
                break;



        }

    }

    /**
     *
     * KeyReleased Events
     *
     * @param keyboardEvent
     */
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {


        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_Q:
                //TODO:COde for when punch ends
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_E:
                //TODO: Code for when def ends
                lastKey = new KeyboardEvent();
                lastKey.setKey(KeyboardEvent.KEY_3);
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_X:
                //TODO: Code for when kick ends
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_F:
                //TODO: Code for when burst ends
                sideMoveSkinSetter();
                break;
        }
    }

    /**
     * Decides witch Skin to load depending on state
     */
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

    /**
     *
     * Check if you can move in a direction
     *
     * @param keyboardEvent
     * @return
     */
    private boolean checkBounderies(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_W:
                if (image.getY() - speed < Game.topBonderi) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_A:
                if (image.getX() - speed < Game.leftBonderi) {
                    return false;
                }
                if (checker.checkPlayerCollision(keyboardEvent)){
                    return false;
                }
                break;
            case KeyboardEvent.KEY_S:
                if (image.getY() + speed > Game.bottomBounderi) {
                    return false;
                }
                break;
            case KeyboardEvent.KEY_D:
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

    //Getters
    public int getPosx() {
        return image.getX();
    }

    public int getPosy() {
        return image.getY();
    }

    @Override
    public int getWidth() {
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

    public KeyboardEvent getPreviousKey() {
        return previousKey;
    }

    public boolean facingRight(){
        return isRight;
    }

    public boolean isKeyPressed(){
        return isKeyPressed;
    }

    public void setKeyPressed(){
        isKeyPressed = false;
    }

    @Override
    public void setSkin(boolean direction){
        if(direction) {
            image.load(SkinTypeVegeta.VegetaHitRight.getPath());
        } else {
            image.load(SkinTypeVegeta.VegetaHitLeft.getPath());
        }
    }

    @Override
    public void setPos(int x, int y, boolean direction){
        image.delete();
        if(direction) {
            image = new Picture(x, y, SkinTypeVegeta.VegetaFlyLeft.getPath());
            image.draw();
        } else{
            image = new Picture(x, y, SkinTypeVegeta.VegetaFlyRight.getPath());
            image.draw();
        }
        sideMoveSkinSetter();
        image.draw();
    }

    @Override
    public void moveInDirection(int xPos, boolean direction) throws InterruptedException {
        if(direction) {
            boolean dir = (xPos < image.getX()) ? true : false;
            image.delete();
            int x = image.getX();
            int xMove = x + 100;
            int xLess = x - 100;
            int y = image.getY();
            if (dir) {
                while (x < xMove) {
                    x++;
                    image.delete();
                    image = new Picture(x, y, SkinTypeVegeta.VegetaFallLeft.getPath());
                    image.draw();
                    Thread.sleep(2);
                }

            } else {
                while (x > xLess) {
                    x--;
                    image.delete();
                    image = new Picture(x, y, SkinTypeVegeta.VegetaFallRight.getPath());
                    image.draw();
                    Thread.sleep(2);
                }
            }
        }

    }

    public void clean(){
        image.delete();
        k.removeEventListener(w);
        k.removeEventListener(a);
        k.removeEventListener(s);
        k.removeEventListener(d);
        k.removeEventListener(qPressed);
        k.removeEventListener(qReleased);
        k.removeEventListener(ePressed);
        k.removeEventListener(eReleased);
        k.removeEventListener(fPressed);
        k.removeEventListener(fReleased);
        k.removeEventListener(xPressed);
        k.removeEventListener(xReleased);
    }

    //Setters
    @Override
    public void setColisonCheker(PlayerColissionChecker cheker) {
        this.checker = cheker;
    }

}
