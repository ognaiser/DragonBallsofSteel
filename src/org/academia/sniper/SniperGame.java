package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SniperGame {

    //Todo: crate a gameObject Factory, MouseHadler ;

    Picture background;
    protected boolean isGameOver = false;
    public static final int apparenceTime = 2000;

    public void init(){

        //Background
        background = new Picture(0,0, "Resources/sniper-scenario2-sample.jpg");
        background.draw();

        start();
    }

    public void start(){



        while (!isGameOver){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
