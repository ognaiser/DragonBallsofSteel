package org.academia.dragonballsofsteel.players;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseHandlerTest implements MouseHandler{


    public MouseHandlerTest() {
        Mouse m = new Mouse(this);

        m.addEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println(mouseEvent.getX() + " :X");
        System.out.println(mouseEvent.getY() + " :Y");
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
