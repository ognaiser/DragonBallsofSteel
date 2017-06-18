package org.academia.sniper;

import org.academiadecodigo.simplegraphics.mouse.Mouse;
import org.academiadecodigo.simplegraphics.mouse.MouseEvent;
import org.academiadecodigo.simplegraphics.mouse.MouseEventType;
import org.academiadecodigo.simplegraphics.mouse.MouseHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MouseController implements MouseHandler{

    private Picture controler;
    private GameObject[] enemies;
    private Player player;
    private Mouse m;

    public MouseController(GameObject[] enemies, Player player) {
        m = new Mouse(this);
        m.addEventListener(MouseEventType.MOUSE_CLICKED);
        controler = new Picture(0,0,"Resources/enemy.png");
        this.enemies = enemies;
        this.player = player;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        if ((mouseEvent.getX() >= WindowPos.WINDOW_LEFT_1.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_LEFT_1.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_LEFT_1.getY() && mouseEvent.getY() <= WindowPos.WINDOW_LEFT_1.getY() + controler.getHeight()){
            checkEnemies(WindowPos.WINDOW_LEFT_1);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_LEFT_2.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_LEFT_2.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_LEFT_2.getY() && mouseEvent.getY() <= WindowPos.WINDOW_LEFT_2.getY() + controler.getHeight()){
            checkEnemies(WindowPos.WINDOW_LEFT_2);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_LEFT_3.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_LEFT_3.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_LEFT_3.getY() && mouseEvent.getY() <= WindowPos.WINDOW_LEFT_3.getY() + controler.getHeight()){
            checkEnemies(WindowPos.WINDOW_LEFT_3);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_LEFT_4.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_LEFT_4.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_LEFT_4.getY() && mouseEvent.getY() <= WindowPos.WINDOW_LEFT_4.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_LEFT_4);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_LEFT_5.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_LEFT_5.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_LEFT_5.getY() && mouseEvent.getY() <= WindowPos.WINDOW_LEFT_5.getY() + controler.getHeight()){
            checkEnemies(WindowPos.WINDOW_LEFT_5);

        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_MIDDLE_1.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_MIDDLE_1.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_MIDDLE_1.getY() && mouseEvent.getY() <= WindowPos.WINDOW_MIDDLE_1.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_MIDDLE_1);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_MIDDLE_2.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_MIDDLE_2.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_MIDDLE_2.getY() && mouseEvent.getY() <= WindowPos.WINDOW_MIDDLE_2.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_MIDDLE_2);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_MIDDLE_3.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_MIDDLE_3.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_MIDDLE_3.getY() && mouseEvent.getY() <= WindowPos.WINDOW_MIDDLE_3.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_MIDDLE_3);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_MIDDLE_4.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_MIDDLE_4.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_MIDDLE_4.getY() && mouseEvent.getY() <= WindowPos.WINDOW_MIDDLE_4.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_MIDDLE_4);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_MIDDLE_5.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_MIDDLE_5.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_MIDDLE_5.getY() && mouseEvent.getY() <= WindowPos.WINDOW_MIDDLE_5.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_MIDDLE_5);
        }

        if ((mouseEvent.getX() >= WindowPos.WINDOW_RIGHT_1.getX()&& mouseEvent.getX() <= WindowPos.WINDOW_RIGHT_1.getX() + controler.getWidth())
                && mouseEvent.getY() >= WindowPos.WINDOW_RIGHT_1.getY() && mouseEvent.getY() <= WindowPos.WINDOW_RIGHT_1.getY() + controler.getHeight()){

            checkEnemies(WindowPos.WINDOW_RIGHT_1);
        }


    }

    private void checkEnemies(WindowPos pos){

        for (int i = 0; i < enemies.length; i++) {
            if (enemies[i].getPosx() == pos.getX() && enemies[i].getPosy() == pos.getY()){
                player.addScore(enemies[i].clicked());
                return;
            }
        }

    }

    public void removeListners(){
        m.removeEventListener(MouseEventType.MOUSE_CLICKED);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
}
