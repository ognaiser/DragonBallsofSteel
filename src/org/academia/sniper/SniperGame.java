package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;

public class SniperGame {

    private Picture background;
    private boolean isGameOver = false;
    private int gameTime = 60000;
    private Player player;
    private GameObjectFactory factory;
    private GameObject[] enemies;
    private int round;
    private MouseController mouse;

    public void init() {

        round = 0;

        //Background
        background = new Picture(0, 0, "Resources/Sniper_BG.jpg");
        background.draw();

        player = new Player();
        factory = new GameObjectFactory();
        enemies = new GameObject[4];


        start();
    }

    private void start() {

        enemies = factory.createObject(round);
        mouse = new MouseController(enemies,player);

        while (!isGameOver) {



            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }

            checkRound();
            gameTime -= 100;
            checkGameOver();

        }

    }

    private void checkRound(){

        for (int i = 0; i < enemies.length; i++) {
            if (!enemies[i].isCLiked()){
                return;
            }
        }

        round++;
        enemies = factory.createObject(round);

    }

    private void checkGameOver() {
        if (gameTime == 0) {
            isGameOver = true;
            System.out.println("Game Over! Score: " + player.getScore());
            mouse.removeListners();
        }
    }
}
