package org.academia.dragonballsofsteel.Tests;

import org.academia.dragonballsofsteel.SkinType;
import org.academia.dragonballsofsteel.players.PlayerOneHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class HandlerTest {

    public static void main(String[] args) {

        //BackGround
        Picture back = new Picture(0,0,SkinType.Back.getPath());
        back.draw();

        //Player1
        PlayerOneHandler Playertest = new PlayerOneHandler( 10);

    }

}
