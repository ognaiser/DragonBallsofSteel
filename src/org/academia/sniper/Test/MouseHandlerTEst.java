package org.academia.sniper.Test;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;

public class MouseHandlerTEst implements MouseHandler {


    public MouseHandlerTEst() {

        /**
         *
         * Fix Windows ALL FULL OPEN
         * Fix Right Window blue is showing
         *
         * Left:
         * 1- 1302 x  188 Y
         * 2- 191 X 256 Y
         * 3- 245 x 325 Y
         * 4- 365 X 399 Y
         * 5- 302 X 466 Y
         *
         * Middle:
         * 1- 552 X 238 Y
         * 2- 657 X 299 Y
         * 3- 553 X 356 Y
         * 4- 505 X 420 Y
         * 5- 657 X 481 Y
         *
         * Right:
         * 1-1027 X 348 Y
         */

        Mouse m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        System.out.println("X: "+ mouseEvent.getX());
        System.out.println("Y: "+ mouseEvent.getY());
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
