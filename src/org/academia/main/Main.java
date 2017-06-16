package org.academia.main;

import org.academia.dragonballsofsteel.Game;

public class Main {


    public static void main(String[] args) throws InterruptedException {

        MainKeyHandler handler = new MainKeyHandler();


        while (true) {

            if (handler.isGameStarted) {

                switch (handler.i){
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


            Thread.sleep(100);
        }

    }

}
