package org.academia.sniper;

public class Player {

    private int score = 0;

    public void addScore(int points){
        score = score + points;
    }

    public int getScore() {
        return score;
    }

}