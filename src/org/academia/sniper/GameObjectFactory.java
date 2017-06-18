package org.academia.sniper;

public class GameObjectFactory {

    private WindowPos pos;

    public GameObject createObject(){

        int choose;

        choose = (int)(Math.random() * 1) + 1;

        switch (choose){
            case 1:
                pos = getPos();
                return new Enemy(pos.getX(), pos.getY());
            default:
                pos = getPos();
                return new Enemy(pos.getX(), pos.getY());
        }
    }

    private WindowPos getPos(){
        return WindowPos.values()[(int)(Math.random() * 11)];
    }
}
