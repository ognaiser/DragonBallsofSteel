package org.academia.sniper;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Enemy extends GameObject {

    private Picture picture;
    private int scoreAwarded = 10;

    public Enemy(int x, int y) {
        super(x,y);

        picture = new Picture(x,y, "Resources/enemy.png");
        picture.draw();

    }

    @Override
    public int clicked() {
        super.setCliked();
        picture.delete();
        return scoreAwarded;
    }
}