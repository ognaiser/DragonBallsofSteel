package org.academia.dragonballsofsteel;

import org.academia.dragonballsofsteel.players.Player;
import org.academia.dragonballsofsteel.players.PlayerColissionChecker;
import org.academia.dragonballsofsteel.players.PlayerType;
import org.academiadecodigo.simplegraphics.graphics.Canvas;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Game Logic
 */

public class Game {

    protected boolean isGameOver = false;

    public void init(){

        //Todo: Get Instruction Screen

        //BackGround
        Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
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



            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }

    }

}
