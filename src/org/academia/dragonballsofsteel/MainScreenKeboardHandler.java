package org.academia.dragonballsofsteel;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MainScreenKeboardHandler implements KeyboardHandler{

    private Keyboard k = new Keyboard(this);
    private KeyboardEvent space = new KeyboardEvent();


    public MainScreenKeboardHandler() {

        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        addListners();

    }

    public void addListners(){
        k.addEventListener(space);
    }

    public void removeListners(){
        k.removeEventListener(space);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_SPACE:
                Game.foward = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
