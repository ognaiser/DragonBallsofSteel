package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends GameObject {

    private Picture picture;
    private int scoreAwarded = 10;

    // TODO create enemy enum

    public Enemy(int X, int Y) {
        super(2000);
        picture = new Picture(X,Y, "Resources/kim-enemy.png");
        picture.draw();
    }

    @Override
    public int clicked() {
        return scoreAwarded;
    }
}