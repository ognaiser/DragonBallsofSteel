package org.academia.main;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class MainKeyHandler implements KeyboardHandler {

    protected Picture[] sel = new Picture[4];
    protected Picture menu;
    protected boolean unlocked = false;
    private boolean isGameStarted;
    private int i = 0;
    private Keyboard k = new Keyboard(this);
    private KeyboardEvent space = new KeyboardEvent();
    private KeyboardEvent left = new KeyboardEvent();
    private KeyboardEvent right = new KeyboardEvent();
    private KeyboardEvent kill = new KeyboardEvent();
    private int count = 0;

    public MainKeyHandler() {

        //Picture initialization

        Picture screenOne = new Picture(188, 255, SkinMenus.DragonBalls.getPath());
        screenOne.draw();
        Picture screenTwo = new Picture(188, 256, SkinMenus.SnipeMenu.getPath());
        Picture screenThree = new Picture(185, 255, SkinMenus.galo_main.getPath());
        Picture screenFour = new Picture(185, 265, SkinMenus.car_menu.getPath());

        //BackGround Picture
        menu = new Picture(0, 0, SkinMenus.ArcadeMenu.getPath());
        menu.draw();

        //Picture Array initialization
        sel[0] = screenOne;
        sel[1] = screenTwo;
        sel[2] = screenThree;
        sel[3] = screenFour;


        //Events initialization
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(right);
        k.addEventListener(left);
        k.addEventListener(space);

        kill.setKey(KeyboardEvent.KEY_K);
        kill.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(kill);

        //Easter Eggs Listener

        KeyboardEvent c = new KeyboardEvent();
        c.setKey(KeyboardEvent.KEY_C);
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent a = new KeyboardEvent();
        a.setKey(KeyboardEvent.KEY_A);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent r = new KeyboardEvent();
        r.setKey(KeyboardEvent.KEY_R);
        r.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent b = new KeyboardEvent();
        b.setKey(KeyboardEvent.KEY_B);
        b.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent h = new KeyboardEvent();
        h.setKey(KeyboardEvent.KEY_H);
        h.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent i = new KeyboardEvent();
        i.setKey(KeyboardEvent.KEY_I);
        i.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        KeyboardEvent n = new KeyboardEvent();
        n.setKey(KeyboardEvent.KEY_N);
        n.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(c);
        k.addEventListener(a);
        k.addEventListener(r);
        k.addEventListener(b);
        k.addEventListener(s);
        k.addEventListener(h);
        k.addEventListener(i);
        k.addEventListener(n);

    }

    protected void menuScreenInit() {

        sel[0].draw();
        menu.draw();
        i = 0;
        isGameStarted = false;

        k.addEventListener(right);
        k.addEventListener(left);
        k.addEventListener(space);

    }

    protected void removeListners() {
        k.removeEventListener(left);
        k.removeEventListener(right);
        k.removeEventListener(space);
        k.removeEventListener(kill);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (count != 11) {
                    if (i < sel.length - 2) {
                        desingMenu();
                    }
                } else {
                    if (i < sel.length - 1) {
                        desingMenu();
                    }
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (i > 0) {
                    i--;
                    sel[i + 1].delete();
                    sel[i].draw();
                    menu.delete();
                    menu.draw();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                isGameStarted = true;
                menu.delete();
                sel[i].delete();
                break;
            case KeyboardEvent.KEY_C:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_A:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_R:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_B:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_S:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_H:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_I:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_N:
                checkEasterEgg(keyboardEvent);
                break;
            case KeyboardEvent.KEY_K:
                System.exit(1);
                break;

        }
    }

    private void desingMenu() {
        i++;
        sel[i - 1].delete();
        sel[i].draw();
        menu.delete();
        menu.draw();
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean isGameStarted() {
        return isGameStarted;
    }

    public int getI() {
        return i;
    }


    private void checkEasterEgg(KeyboardEvent keyboardEvent) {

        if (count == 0 && keyboardEvent.getKey() == KeyboardEvent.KEY_C) {
            count++;
        } else if (count == 1 && keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            count++;
        } else if (count == 2 && keyboardEvent.getKey() == KeyboardEvent.KEY_R) {
            count++;
        } else if (count == 3 && keyboardEvent.getKey() == KeyboardEvent.KEY_B) {
            count++;
        } else if (count == 4 && keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            count++;
        } else if (count == 5 && keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            count++;
        } else if (count == 6 && keyboardEvent.getKey() == KeyboardEvent.KEY_H) {
            count++;
        } else if (count == 7 && keyboardEvent.getKey() == KeyboardEvent.KEY_I) {
            count++;
        } else if (count == 8 && keyboardEvent.getKey() == KeyboardEvent.KEY_A) {
            count++;
        } else if (count == 9 && keyboardEvent.getKey() == KeyboardEvent.KEY_N) {
            count++;
        } else if (count == 10 && keyboardEvent.getKey() == KeyboardEvent.KEY_S) {
            count++;
        } else if (count != 11) {
            count = 0;
        }


    }


    public int getCount() {
        return count;
    }
}
