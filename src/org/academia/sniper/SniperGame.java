package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.LinkedList;

public class SniperGame {

    private Picture background;
    private boolean isGameOver = false;
    private int gameTime = 60000;
    private Player player;
    private final int numberMaxOfEnemiesOnField = 4;
    private GameObjectFactory factory;
    private LinkedList<GameObject> enemies;

    public void init() {

        //Background
        background = new Picture(0, 0, "Resources/Sniper_BG.jpg");
        background.draw();

        player = new Player();
        factory = new GameObjectFactory();
        enemies = new LinkedList<>();

        start();
    }

    public void start() {

        enemies.add(factory.createObject());

        while (!isGameOver) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }

            gameTime -= 100;
            checkGameOver();

        }
    }

    public void checkGameOver() {
        if (gameTime == 0) {
            isGameOver = true;
            System.out.println("Game Over");
        }
    }
}
