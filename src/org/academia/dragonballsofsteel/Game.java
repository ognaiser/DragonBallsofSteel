package org.academia.dragonballsofsteel;

import org.academia.dragonballsofsteel.players.Player;
import org.academia.dragonballsofsteel.players.PlayerColissionChecker;
import org.academia.dragonballsofsteel.players.PlayerType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Game Logic
 */

public class Game {

    //TODO: Fix attack BUGS!!!! (WHAT HAVE YOU DONE RUBEN!!!) (They are not taking damage or you delete the souts) **
    //TODO: Delete handlers when exiting and all the pictures
    //TODO: fix bug when going up skin doesn't t Change Direction (not sure if it was working before may be YOUR FAULT THO!)
    //TODO: get thing when you go down or up you go to the side
    //TODO: get a health Display


    //** After some bug testing i think the bg only hapens when players are on the ground

    //I fix start skins and you have new skins on all of the enums including start and ending screens and kick and charge animations both directions and you have hit animations if you want!
    //I also got you kamehameha skins!
    //Did some changes to backgorund image

    protected boolean isGameOver = false;
    public static final int bottomBounderi = 581;
    public static final int rightBounderi = 1118;
    public static final int topBonderi = 146;
    public static final int leftBonderi = 143;
    Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());


    public void init(){

        //Todo: Get Instruction Screen

        //BackGround
        back.draw();

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
                if (checker.fightingRange() && (player1.getKey().getKey() != KeyboardEvent.KEY_L)) {
                    player1.takingDamage(player.punch());
                    System.out.println("Goku : " + player1.getHealth());
                    player.setKeyPressed();
                }
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_E && player.isKeyPressed()){
                    player.blockAttack(checker.fightingRange());
                    player.setKeyPressed();
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_X && player.isKeyPressed()){
                if (checker.fightingRange() && (player1.getKey().getKey() != KeyboardEvent.KEY_L)) {
                    player1.takingDamage(player.kick());
                    System.out.println("Goku : " + player1.getHealth());
                    player.setKeyPressed();
                }
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_F && player.isKeyPressed()){
                player.burstOfEnergy();
                player.setKeyPressed();
            }

            if(player.getKey().getKey() == KeyboardEvent.KEY_A && player.getPreviousKey().getKey() == KeyboardEvent.KEY_F &&
                    player.isKeyPressed()){
                if(player.teleport()){
                    player.setPos(player1.getPosx() + player1.getWidth() + 5, player1.getPosy());
                }
                player.setKeyPressed();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_K && player1.isKeyPressed()){
                if (checker.fightingRange() && (player.getKey().getKey() != KeyboardEvent.KEY_E)) {
                    player.takingDamage(player1.punch());
                    System.out.println("Vegeta : " + player.getHealth());
                    player1.setKeyPressed();
                }
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_P && player1.isKeyPressed()){
                if (checker.fightingRange() && (player.getKey().getKey() != KeyboardEvent.KEY_E)) {
                    player.takingDamage(player1.kick());
                    System.out.println("Vegeta : " + player.getHealth());
                    player1.setKeyPressed();
                }
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_O && player1.isKeyPressed()){
                player1.burstOfEnergy();
                player1.setKeyPressed();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_L && player1.isKeyPressed()){
                player1.blockAttack(checker.fightingRange());
                player1.setKeyPressed();
            }

            if(player1.getKey().getKey() == KeyboardEvent.KEY_O && player1.getPreviousKey().getKey() == KeyboardEvent.KEY_P &&
                    player1.isKeyPressed()){
                if(player1.teleport()){
                    player1.setPos(player.getPosx() + player.getWidth() + 5, player.getPosy());
                }
                player1.setKeyPressed();
            }

            if(player.isDefeated() || player1.isDefeated()){
                back.draw();
                isGameOver = true;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }
        }




        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }

        back.delete();
    }

}
