package org.academia.main;

import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MainKeyHandler implements KeyboardHandler {

    protected boolean isGameStarted;
    protected int i = 0;
    protected Picture[] sel = new Picture[3];
    protected Picture menu;
    protected Keyboard k = new Keyboard(this);
    protected KeyboardEvent left = new KeyboardEvent();
    protected KeyboardEvent right = new KeyboardEvent();
    protected KeyboardEvent space = new KeyboardEvent();

    public MainKeyHandler() {

        //Picture initialization

        Picture a = new Picture(185, 265, SkinMenus.DragonBalls.getPath());
        a.draw();
        Picture b = new Picture(300, 300, SkinTypeVegeta.VegetaDefLeft.getPath());
        Picture c = new Picture(300, 300, SkinTypeVegeta.VegetaFallLeft.getPath());

        //BackGround Picture
        menu = new Picture(0, 0, SkinMenus.ArcadeMenu.getPath());
        menu.draw();

        //Picture Array initialization
        sel[0] = a;
        sel[1] = b;
        sel[2] = c;

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

    protected void removeListners(){
        k.removeEventListener(left);
        k.removeEventListener(right);
        k.removeEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (i < sel.length - 1) {
                    i++;
                    sel[i-1].delete();
                    sel[i].draw();
                    menu.delete();
                    menu.draw();
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (i > 0) {
                    i--;
                    sel[i+1].delete();
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

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
