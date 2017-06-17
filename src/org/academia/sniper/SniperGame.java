package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SniperGame {

    Picture background;
    private boolean isGameOver = false;
    private int timePassed = 60000;
    private Player player;


    public void init() {

        //Background
        background = new Picture(0, 0, "Resources/sniper-scenario2-sample.jpg");
        background.draw();

        player = new Player();

        start();
    }

    public void start() {

        while (!isGameOver) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }

            timePassed -= 100;
            checkGameOver();

        }
    }

    public void checkGameOver() {
        if (timePassed == 0) {
            isGameOver = true;
        }
    }
}
