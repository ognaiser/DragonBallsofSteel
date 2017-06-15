package org.academia.main.Tests;

import org.academia.dragonballsofsteel.SkinTypeExtra;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 15/06/2017.
 */
public class MenuTest {

    public static void main(String[] args) {

        Picture menu = new Picture(0,0, SkinTypeExtra.Arcade_Menu.getPath());
        menu.draw();

    }

}
