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
    private KeyboardEvent w = new KeyboardEvent();
    private KeyboardEvent a = new KeyboardEvent();
    private KeyboardEvent s = new KeyboardEvent();
    private KeyboardEvent d = new KeyboardEvent();
    private KeyboardEvent kPressed = new KeyboardEvent();
    private KeyboardEvent kReleased = new KeyboardEvent();
    private KeyboardEvent lPressed = new KeyboardEvent();
    private KeyboardEvent lReleased = new KeyboardEvent();
    private KeyboardEvent pPressed = new KeyboardEvent();
    private KeyboardEvent pReleased = new KeyboardEvent();
    private KeyboardEvent oPressed = new KeyboardEvent();
    private KeyboardEvent oReleased = new KeyboardEvent();
    private Keyboard k;


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

        w.setKey(KeyboardEvent.KEY_UP);
        w.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        a.setKey(KeyboardEvent.KEY_LEFT);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        s.setKey(KeyboardEvent.KEY_DOWN);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        d.setKey(KeyboardEvent.KEY_RIGHT);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kPressed.setKey(KeyboardEvent.KEY_K);
        kPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        kReleased.setKey(KeyboardEvent.KEY_K);
        kReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        lPressed.setKey(KeyboardEvent.KEY_L);
        lPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        lReleased.setKey(KeyboardEvent.KEY_L);
        lReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        pPressed.setKey(KeyboardEvent.KEY_P);
        pPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        pReleased.setKey(KeyboardEvent.KEY_P);
        pReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        oPressed.setKey(KeyboardEvent.KEY_O);
        oPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        oReleased.setKey(KeyboardEvent.KEY_O);
        oReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        //Inicialize Keyboard
        k = new Keyboard(this);

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

        //Kick Key Add
        k.addEventListener(pPressed);
        k.addEventListener(pReleased);

        //Burst Key Add
        k.addEventListener(oPressed);
        k.addEventListener(oReleased);


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
                if (isRight) {
                    image.load(SkinTypeGoku.GokuPunchLeft.getPath());
                } else {
                    image.load(SkinTypeGoku.GokuPunchRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_L:
                if (isRight){
                    image.load(SkinTypeGoku.GokuDefLeft.getPath());
                }else {
                    image.load(SkinTypeGoku.GokuDefRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_P:
                if (isRight){
                    image.load(SkinTypeGoku.GokuKickLeft.getPath());
                }else {
                    image.load(SkinTypeGoku.GokuKickRight.getPath());
                }
                break;
            case KeyboardEvent.KEY_O:
                image.load(SkinTypeGoku.GokuCharge.getPath());
                break;
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
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_L:
                lastKey = new KeyboardEvent();
                lastKey.setKey(KeyboardEvent.KEY_3);
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_P:
                sideMoveSkinSetter();
                break;

            case KeyboardEvent.KEY_O:
                sideMoveSkinSetter();
                break;
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

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public void setSideSkin(boolean direction){
        if(direction) {
            image.load(SkinTypeGoku.GokuHitRight.getPath());
        } else {
            image.load(SkinTypeGoku.GokuHitLeft.getPath());
        }
    }

    /**
     * moves a image from the desired Y to the max Y of the Canvas
     *
     * @param pic set a new image
     * @param y where the pic will appear
     * @throws InterruptedException
     */
    public void setSkin(Picture pic, int y) throws InterruptedException {
        image.delete();
        image = pic;
        image.draw();

        while (y < 581) {
            y++;
            image.delete();
            image = new Picture(image.getX(), y, SkinTypeGoku.GokuDeadRigh.getPath());
            image.draw();
            Thread.sleep(2);
        }
        image.delete();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
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
                    if(x > 1118){
                        image.delete();
                        image = new Picture(x, y, SkinTypeGoku.GokuFallLeft.getPath());
                        image.draw();
                        break;
                    }
                    image.delete();
                    image = new Picture(x, y, SkinTypeGoku.GokuFallLeft.getPath());
                    image.draw();
                    Thread.sleep(2);
                }

            } else {
                while (x > xLess) {
                    x--;
                    if(x < 143){
                        image.delete();
                        image = new Picture(x, y, SkinTypeGoku.GokuFallRight.getPath());
                        image.draw();
                        break;
                    }
                    image.delete();
                    image = new Picture(x, y, SkinTypeGoku.GokuFallRight.getPath());
                    image.draw();
                    Thread.sleep(2);
                }
            }
        }
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    public void setPos(int x, int y, boolean direction){
        image.delete();
        if(direction) {
            image = new Picture(x, y, SkinTypeGoku.GokuFlyRight.getPath());
        }
        else{
            image = new Picture(x, y, SkinTypeGoku.GokuFlyLeft.getPath());
        }
        sideMoveSkinSetter();
        image.draw();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public void setSpeed(int amount){
        if(amount == 0){
            speed = 10;
            return;
        }
        if(speed > 20){
            return;
        }
        speed = speed + amount;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    public int getPosx() {
        return image.getX();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    public int getPosy() {
        return image.getY();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public int getWidth() {
        return image.getWidth();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public int getHeight() {
        return image.getHeight();
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public int getSpeed() {
        return speed;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public KeyboardEvent getLastKey() {
        return lastKey;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    public KeyboardEvent getPreviousKey() {
        return previousKey;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public boolean isKeyPressed() {
        return isKeyPressed;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public void setKeyPressed() {
        isKeyPressed = false;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public boolean facingRight(){
        return isRight;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    @Override
    public void setColisonCheker(PlayerColissionChecker cheker) {
        this.checker = cheker;
    }

    /**
     * Description on the Interface
     * @see PlayerHandler
     */
    public void clean(){

        image.delete();
        k.removeEventListener(w);
        k.removeEventListener(a);
        k.removeEventListener(s);
        k.removeEventListener(d);
        k.removeEventListener(kPressed);
        k.removeEventListener(kReleased);
        k.removeEventListener(lPressed);
        k.removeEventListener(lReleased);
        k.removeEventListener(oPressed);
        k.removeEventListener(oReleased);
        k.removeEventListener(pPressed);
        k.removeEventListener(pReleased);
    }
}
