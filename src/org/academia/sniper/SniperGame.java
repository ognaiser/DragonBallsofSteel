package org.academia.sniper;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class SniperGame {

    private Picture background;
    private boolean isGameOver = false;
    private int gameTime = 0000;
    private Player player;
    private GameObjectFactory factory;
    private GameObject[] enemies;
    private int round;
    private MouseController mouse;
    private Text text;

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
        text = new Text(900, 100, "Score: " + player.getScore());
        text.grow(50,50);
        text.draw();

        while (!isGameOver) {

            text.setText("Score: " + player.getScore());



            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }

            checkRound();
            gameTime -= 100;
            checkGameOver();

        }

        //Delete everything
        background.delete();
        for (int i = 0; i < enemies.length; i++) {
            enemies[i].setCliked();
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
            mouse.removeListners();

            text.delete(); // Delete score from left side
            text = new Text(640, 390, "Final score: " + player.getScore());
            text.setColor(Color.DARK_GRAY);
            text.grow(250,200);
            text.draw();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
    }
}
