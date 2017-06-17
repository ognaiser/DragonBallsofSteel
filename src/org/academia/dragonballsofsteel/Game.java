package org.academia.dragonballsofsteel;

import org.academia.dragonballsofsteel.players.Player;
import org.academia.dragonballsofsteel.players.PlayerColissionChecker;
import org.academia.dragonballsofsteel.players.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Game Logic
 */

public class Game {

    protected boolean isGameOver = false;
    public static final int bottomBounderi = 290;
    public static final int rightBounderi = 760;


    public void init(){

        //Todo: Get Instruction Screen

        //BackGround
        Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
        back.draw();

        //Todo fix background

        //Game Start
        start();
    }

    public void start(){
        //Player1
        Player player = new Player(PlayerType.PLAYERONE);

        //Player2
        Player player1 = new Player(PlayerType.PLAYERTWO);

        //Colision Cheker
        PlayerColissionChecker checker = new PlayerColissionChecker(player,player1);
        player.setColisionChecker(checker);
        player1.setColisionChecker(checker);

        while (!isGameOver){

            if(player.getKey().getKey() == KeyboardEvent.KEY_Q && player.isKeyPressed()){
                if (checker.fightingRange()){ //&& !player1.blockAttack(checker.fightingRange()) && (player1.getKey().getKey() != KeyboardEvent.KEY_L && player1.isKeyPressed())) {
                    player1.takingDamage(50);
                    System.out.println("Goku : " + player1.getHealth());
                    player.setKeyPressed();
                }
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_E && player.isKeyPressed()){
                    player.blockAttack(checker.fightingRange());
                    player.setKeyPressed();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_Q && player.isKeyPressed()){
                if (checker.fightingRange()){// && !player.blockAttack(checker.fightingRange()) && (player.getKey().getKey() != KeyboardEvent.KEY_L && player.isKeyPressed())) {
                    player.takingDamage(50);
                    System.out.println("Vegeta : " + player.getHealth());
                    player1.setKeyPressed();
                }
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_E && player.isKeyPressed()){
                    player1.blockAttack(checker.fightingRange());
                    player1.setKeyPressed();
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

    }

}
