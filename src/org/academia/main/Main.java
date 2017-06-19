package org.academia.main;

import org.academia.carcrash.CarCrashX;
import org.academia.dragonballsofsteel.Game;
import org.academia.main.Tests.MouseTest;
import org.academia.noughtsandcrosses.NoughtsAndCrosses;
import org.academia.sniper.SniperGame;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

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
                        handler.removeListners();
                        SniperGame sniperGame = new SniperGame();
                        sniperGame.init();
                        handler.menuScreenInit();
                        break;
                    case 2:
                        handler.removeListners();
                        NoughtsAndCrosses noughtsAndCrosses = new NoughtsAndCrosses();
                        noughtsAndCrosses.init();
                        handler.menuScreenInit();
                        break;
                    case 3:
                        handler.removeListners();
                        CarCrashX carCrashX = new CarCrashX();
                        carCrashX.init();
                        handler.menuScreenInit();
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

        InputStream in = null;

        try {
            in = new FileInputStream("Resources/dial-up-modem-02.wav");
        } catch (FileNotFoundException e) {
        }

        // create an audiostream from the inputstream
        AudioStream audioStream = null;
        try {
            audioStream = new AudioStream(in);
        } catch (IOException e) {
        }

        // play the audio clip with the audioplayer class
        AudioPlayer.player.start(audioStream);


        handler.removeListners();

        handler.unlocked = true;
        handler.sel[handler.getI()].delete();

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

        text.delete();
        text1.delete();

        Picture hacking;
        hacking = new Picture(185, 255, SkinMenus.hacking_1.getPath());

        //2 Part
        for (int i = 0; i < 5; i++) {

            hacking = new Picture(185, 255, SkinMenus.hacking_1.getPath());
            hacking.draw();
            handler.menu.draw();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }

            hacking.load(SkinMenus.hacking_2.getPath());
            hacking.draw();
            handler.menu.draw();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }

            hacking.load(SkinMenus.hacking_3.getPath());
            hacking.draw();
            handler.menu.draw();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }

            hacking.load(SkinMenus.hacking_4.getPath());
            hacking.draw();
            handler.menu.draw();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }

            hacking.load(SkinMenus.hacking_5.getPath());
            hacking.draw();
            handler.menu.draw();

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
            }
        }
        //Last Part

        hacking.load(SkinMenus.hacking_end.getPath());
        hacking.draw();
        handler.menu.draw();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }


        back.delete();

        hacking.delete();


        handler.sel[handler.getI()].draw();
        handler.menu.draw();


        handler.menuScreenInit();
    }

}
