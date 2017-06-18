package org.academia.noughtsandcrosses;

import org.academia.main.SkinMenus;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class NoughtsAndCrosses {

    private int[] game = new int[9];
    private boolean isGameOver = false;
    private MouseListner mouseHandler;
    protected static int turn = 1;
    private Picture back;

    public void init(){

        back = new Picture(0,0, SkinMenus.galo_back.getPath());
        back.draw();

        mouseHandler = new MouseListner(game);

        for (int i = 0; i < game.length; i++) {
            game[i] = 0;
        }

        start();

    }

    public void start(){

        while (!isGameOver){

            checkEndgame();

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
            }

        }

        mouseHandler.m.removeEventListener(MouseEventType.MOUSE_CLICKED);
        removeImages();

    }

    private void removeImages(){
        back.delete();
        for (int i = 0; i < mouseHandler.pictures.length; i++) {
            if (mouseHandler.pictures[i] != null) {
                mouseHandler.pictures[i].delete();
            }
        }
    }

    private void checkEndgame(){

        if (checkPlayerOne()) {
            isGameOver = true;
        }

        if(checkPlayerTwo()){
            isGameOver = true;
        }


    }

    private boolean checkPlayerOne(){

        if (game[0] == 1 && game[1] == 1 && game[2] == 1){
            //P1 Wins
            return true;
        }

        if (game[3] == 1 && game[4] == 1 && game[5] == 1){
            //P1 Wins
            return true;
        }

        if (game[6] == 1 && game[7] == 1 && game[8] == 1){
            //P1 Wins
            return true;
        }

        if (game[0] == 1 && game[4] == 1 && game[8] == 1){
            //P1 Wins
            return true;
        }

        if (game[6] == 1 && game[4] == 1 && game[2] == 1){
            //P1 Wins
            return true;
        }

        return false;

    }

    private boolean checkPlayerTwo(){

        if (game[0] == 2 && game[1] == 2 && game[2] == 2){
            //P2 Wins
            return true;
        }

        if (game[3] == 2 && game[4] == 2 && game[5] == 2){
            //P2 Wins
            return true;
        }

        if (game[6] == 2 && game[7] == 2 && game[8] == 2){
            //P2 Wins
            return true;
        }

        if (game[0] == 2 && game[4] == 2 && game[8] == 2){
            //P2 Wins
            return true;
        }

        if (game[6] == 2 && game[4] == 2 && game[2] == 2){
            //P2 Wins
            return true;
        }

        return false;

    }

}
