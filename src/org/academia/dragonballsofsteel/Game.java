package org.academia.dragonballsofsteel;

import org.academia.dragonballsofsteel.players.MouseHandlerTest;
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
    public static final int bottomBounderi = 581;
    public static final int rightBounderi = 1118;
    public static final int topBonderi = 146;
    public static final int leftBonderi = 143;


    public void init(){

        //Todo: Get Instruction Screen

        //BackGround
        Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
        back.draw();

        MouseHandlerTest m = new MouseHandlerTest();

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
                if (checker.fightingRange() && (!player1.isKeyPressed() && player1.getKey().getKey() != KeyboardEvent.KEY_L)) {
                    player1.takingDamage(player.punch());
                    System.out.println("Goku : " + player1.getHealth());
                    player.setKeyPressed();
                }
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_E && player.isKeyPressed()){
                    player.blockAttack(checker.fightingRange());
                    System.out.println(player.getEnergy());
                    player.setKeyPressed();
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_X && player.isKeyPressed()){
                if (checker.fightingRange() && (!player1.isKeyPressed() && player1.getKey().getKey() != KeyboardEvent.KEY_L)) {
                    player1.takingDamage(player.kick());
                    System.out.println("Goku : " + player1.getHealth());
                    player.setKeyPressed();
                }
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_F && player.isKeyPressed()){
                player.burstOfEnergy();
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_A && player.getPreviousKey().getKey() == KeyboardEvent.KEY_F &&
                    player.isKeyPressed()){
                if(player.teleport()){
                    player.setPos(player1.getPosx() + player1.getWith() + 5, player1.getPosy());
                }
                player.setKeyPressed();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_K && player1.isKeyPressed()){
                if (checker.fightingRange() && (player.isKeyPressed() && player.getKey().getKey() != KeyboardEvent.KEY_E)) {
                    player.takingDamage(player1.punch());
                    System.out.println("Vegeta : " + player.getHealth());
                    player1.setKeyPressed();
                }
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_P && player1.isKeyPressed()){
                if (checker.fightingRange() && (player.isKeyPressed() && player.getKey().getKey() != KeyboardEvent.KEY_E)) {
                    player.takingDamage(player1.kick());
                    System.out.println("Vegeta : " + player.getHealth());
                    player1.setKeyPressed();
                }
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_O && player1.isKeyPressed()){
                player1.burstOfEnergy();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_L && player1.isKeyPressed()){
                player1.blockAttack(checker.fightingRange());
                player1.setKeyPressed();
            }

            if(player.isDefeated() || player1.isDefeated()){
                Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
                back.draw();
                isGameOver = true;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }
    }

}
