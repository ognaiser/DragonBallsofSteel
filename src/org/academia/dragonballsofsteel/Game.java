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


    public void init(){

        //BackGround
        Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
        back.draw();

        System.out.println(back.getWidth() + " " + back.getWidth());

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
    }

}
