package org.academia.sniper;

public class Player {


    private int score = 0;

    public int getScore() {
        return score;
    }

    public void addScore(int points){
        score = score + points;
    }

}