package org.academia.carcrash.car;

import org.academia.carcrash.grid.GridDirection;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class SpecialCarHandler implements KeyboardHandler {

    private Keyboard k ;
    private KeyboardEvent w;
    private KeyboardEvent a;
    private KeyboardEvent s;
    private KeyboardEvent d;
    private Car car;

    public SpecialCarHandler(Car car) {

        k = new Keyboard(this);

        w = new KeyboardEvent();
        a = new KeyboardEvent();
        s = new KeyboardEvent();
        d = new KeyboardEvent();

        w.setKey(KeyboardEvent.KEY_W);
        w.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        a.setKey(KeyboardEvent.KEY_A);
        a.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        d.setKey(KeyboardEvent.KEY_D);
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        k.addEventListener(w);
        k.addEventListener(a);
        k.addEventListener(s);
        k.addEventListener(d);
        this.car = car;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_W:
                car.accelerate(GridDirection.UP,1);
                break;
            case KeyboardEvent.KEY_A:
                car.accelerate(GridDirection.LEFT,1);
                break;
            case KeyboardEvent.KEY_S:
                car.accelerate(GridDirection.DOWN,1);
                break;
            case KeyboardEvent.KEY_D:
                car.accelerate(GridDirection.RIGHT,1);
                break;
        }

    }

    public void deleteHandlers(){
        k.removeEventListener(w);
        k.removeEventListener(s);
        k.removeEventListener(a);
        k.removeEventListener(d);
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
