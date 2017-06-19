package org.academia.noughtsandcrosses;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MouseListner implements MouseHandler {

    protected Mouse m = new Mouse(this);
    protected Picture[] pictures = new Picture[9];
    private int[] game;

    public MouseListner(int[] game) {
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        this.game = game;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if (mouseEvent.getY() >= 187 && mouseEvent.getY() <= 316) {

            if (mouseEvent.getX() >= 397 && mouseEvent.getX() <= 540) {
                if (checkIfClean(0)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[0] = new Picture(367, 140, skins.been.getPath());
                        pictures[0].draw();
                        game[0] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[0] = new Picture(367, 140, skins.kardashian.getPath());
                        pictures[0].draw();
                        game[0] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

            if (mouseEvent.getX() >= 597 && mouseEvent.getX() <= 717) {
                if (checkIfClean(1)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[1] = new Picture(567, 140, skins.been.getPath());
                        pictures[1].draw();
                        game[1] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[1] = new Picture(567, 140, skins.kardashian.getPath());
                        pictures[1].draw();
                        game[1] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }

                }
            }

            if (mouseEvent.getX() >= 738 && mouseEvent.getX() <= 893) {
                if (checkIfClean(2)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[2] = new Picture(738, 140, skins.been.getPath());
                        pictures[2].draw();
                        game[2] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[2] = new Picture(738, 140, skins.kardashian.getPath());
                        pictures[2].draw();
                        game[2] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

        }

        if (mouseEvent.getY() >= 333 && mouseEvent.getY() <= 499) {

            if (mouseEvent.getX() >= 397 && mouseEvent.getX() <= 540) {
                if (checkIfClean(3)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[3] = new Picture(367, 303, skins.been.getPath());
                        pictures[3].draw();
                        game[3] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[3] = new Picture(367, 301, skins.kardashian.getPath());
                        pictures[3].draw();
                        game[3] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

            if (mouseEvent.getX() >= 597 && mouseEvent.getX() <= 717) {
                if (checkIfClean(4)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[4] = new Picture(567, 303, skins.been.getPath());
                        pictures[4].draw();
                        game[4] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[4] = new Picture(567, 303, skins.kardashian.getPath());
                        pictures[4].draw();
                        game[4] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }

                }
            }

            if (mouseEvent.getX() >= 738 && mouseEvent.getX() <= 893) {
                if (checkIfClean(5)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[5] = new Picture(738, 303, skins.been.getPath());
                        pictures[5].draw();
                        game[5] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[5] = new Picture(738, 303, skins.kardashian.getPath());
                        pictures[5].draw();
                        game[5] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

        }

        if (mouseEvent.getY() >= 554 && mouseEvent.getY() <= 650) {

            if (mouseEvent.getX() >= 397 && mouseEvent.getX() <= 540) {
                if (checkIfClean(6)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[6] = new Picture(367, 514, skins.been.getPath());
                        pictures[6].draw();
                        game[6] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[6] = new Picture(367, 514, skins.kardashian.getPath());
                        pictures[6].draw();
                        game[6] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

            if (mouseEvent.getX() >= 597 && mouseEvent.getX() <= 717) {
                if (checkIfClean(7)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[7] = new Picture(567, 514, skins.been.getPath());
                        pictures[7].draw();
                        game[7] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[7] = new Picture(567, 514, skins.kardashian.getPath());
                        pictures[7].draw();
                        game[7] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }

                }
            }

            if (mouseEvent.getX() >= 738 && mouseEvent.getX() <= 893) {
                if (checkIfClean(8)) {
                    if (NoughtsAndCrosses.turn == 1) {
                        pictures[8] = new Picture(738, 514, skins.been.getPath());
                        pictures[8].draw();
                        game[8] = 1;
                        NoughtsAndCrosses.turn = 2;
                    } else {
                        pictures[8] = new Picture(738, 514, skins.kardashian.getPath());
                        pictures[8].draw();
                        game[8] = 2;
                        NoughtsAndCrosses.turn = 1;
                    }
                }
            }

        }

    }


    private boolean checkIfClean(int index) {
        if (game[index] == 0) {
            return true;
        }

        return false;
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
