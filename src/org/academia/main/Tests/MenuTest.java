package org.academia.main.Tests;

import org.academia.dragonballsofsteel.SkinTypeExtra;
import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 15/06/2017.
 */
public class MenuTest implements KeyboardHandler {

    public int i = 0;
    public Picture[] sel = new Picture[7];

    public MenuTest() {

        Picture menu = new Picture(0, 0, SkinTypeExtra.Arcade_Menu.getPath());
        menu.draw();

        Picture a = new Picture(300, 300, SkinTypeVegeta.VegetaDeadLeft.getPath());
        Picture b = new Picture(300, 300, SkinTypeVegeta.VegetaDefLeft.getPath());
        Picture c = new Picture(300, 300, SkinTypeVegeta.VegetaFallLeft.getPath());
        Picture d = new Picture(300, 300, SkinTypeVegeta.VegetaFlyLeft.getPath());
        Picture e = new Picture(300, 300, SkinTypeVegeta.VegetaGroundLeft.getPath());
        Picture f = new Picture(300, 300, SkinTypeVegeta.VegetaPunchLeft.getPath());
        Picture g = new Picture(300, 300, SkinTypeVegeta.VegetaStartLeft.getPath());


        sel[0] = a;
        sel[1] = b;
        sel[2] = c;
        sel[3] = d;
        sel[4] = e;
        sel[5] = f;
        sel[6] = g;

        Keyboard k = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);


        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(right);
        k.addEventListener(left);
        k.addEventListener(space);


    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (i < sel.length - 1) {
                    i++;
                    sel[i-1].delete();
                    sel[i].draw();
                }
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (i > 0) {
                    i--;
                    sel[i+1].delete();
                    sel[i].draw();
                }
                break;
            case KeyboardEvent.KEY_SPACE:
                System.out.println("PIMBA!");
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
