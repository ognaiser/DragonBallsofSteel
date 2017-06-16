package org.academia.main.Tests;

import org.academia.dragonballsofsteel.Game;
import org.academia.dragonballsofsteel.SkinTypeExtra;
import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academia.dragonballsofsteel.Tests.HandlerTest;
import org.academia.main.SkinMenus;
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
    public Picture[] sel = new Picture[3];
    public Picture menu = new Picture(0, 0, SkinMenus.ArcadeMenu.getPath());

    public MenuTest() {


        Picture a = new Picture(185, 265, SkinMenus.DragonBalls.getPath());
        a.draw();
        Picture b = new Picture(300, 300, SkinTypeVegeta.VegetaDefLeft.getPath());
        Picture c = new Picture(300, 300, SkinTypeVegeta.VegetaFallLeft.getPath());

        menu.draw();


        sel[0] = a;
        sel[1] = b;
        sel[2] = c;

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
                Game game = new Game();
                game.init();
                break;

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
