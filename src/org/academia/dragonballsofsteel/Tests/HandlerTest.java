package org.academia.dragonballsofsteel.Tests;

import org.academia.dragonballsofsteel.SkinTypeExtra;
import org.academia.dragonballsofsteel.SkinTypeVegeta;
import org.academia.dragonballsofsteel.players.Player;
import org.academia.dragonballsofsteel.players.PlayerColissionChecker;
import org.academia.dragonballsofsteel.players.PlayerType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HandlerTest {

    public static void main(String[] args) {

        //BackGround
        Picture back = new Picture(0,0, SkinTypeExtra.Back.getPath());
        back.draw();

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
