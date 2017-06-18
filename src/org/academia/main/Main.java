package org.academia.main;

import org.academia.dragonballsofsteel.Game;
import org.academia.main.Tests.MouseTest;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Main {

    private static MainKeyHandler handler = new MainKeyHandler();

    public static void main(String[] args) throws InterruptedException {


        while (true) {

            if (handler.isGameStarted()) {

                switch (handler.getI()){
                    case 0:
                        handler.removeListners();
                        Game game = new Game();
                        game.init();
                        handler.menuScreenInit();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    default:
                        break;
                }

            }

            if (handler.getCount() == 11&& !handler.unlocked){
             easterUnlock();
            }

            Thread.sleep(100);
        }

    }

    private static void easterUnlock(){


        handler.unlocked = true;

        //1 part

        Rectangle back = new Rectangle(188,255,510,312);
        back.setColor(Color.BLACK);
        back.fill();
        handler.menu.draw();

        Text text = new Text(239,307,"Hacking <Academia de Codigo_>");
        text.setColor(Color.GREEN);
        text.draw();

        Text text1 = new Text(239,327,"Trying to steal CarCrash2!");
        text1.setColor(Color.GREEN);
        text1.draw();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        back.delete();
        text.delete();
        text1.delete();

        //2 Part

        Picture hacking = new Picture(185,255,SkinMenus.hacking_1.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
        }

        hacking.load(SkinMenus.hacking_2.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
        }

        hacking.load(SkinMenus.hacking_3.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
        }

        hacking.load(SkinMenus.hacking_4.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
        }

        hacking.load(SkinMenus.hacking_5.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
        }

        //Last Part

        hacking.load(SkinMenus.hacking_end.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        hacking.delete();

        handler.sel[handler.getI()].draw();
        handler.menu.draw();



        System.out.println("unlocked");
    }

}
