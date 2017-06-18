package org.academia.sniper;

public class GameObjectFactory {

    private WindowPos[] pos = new WindowPos[4];
    private GameObject[] enemies = new GameObject[4];

    public GameObject[] createObject(int round) {

        int chance;

        generatePos();

        for (int i = 0; i < enemies.length; i++) {

            chance = (int) (Math.random() * 1) + 1;

            switch (chance) {
                case 1:
                    enemies[i] = new Enemy(pos[i].getX(), pos[i].getY());
                    break;
                default:
                    enemies[i] = new Enemy(pos[i].getX(), pos[i].getY());
                    break;
            }

        }

        return enemies;
    }

    private void generatePos() {

        boolean samePos = true;

        pos[0] = WindowPos.values()[(int) (Math.random() * 10)];

        pos[1] = WindowPos.values()[(int) (Math.random() * 10)];

        while (pos[0].equals(pos[1])) {
            pos[1] = WindowPos.values()[(int) (Math.random() * 10)];
        }

        pos[2] = WindowPos.values()[(int) (Math.random() * 10)];

        while (samePos) {
            if (pos[2].equals(pos[0]) || pos[2].equals(pos[1])){
                pos[2] = WindowPos.values()[(int) (Math.random() * 10)];
            }else {
                samePos = false;
            }
        }

        samePos = true;

        pos[3] = WindowPos.values()[(int) (Math.random() * 10)];

        while (samePos) {
            if (pos[3].equals(pos[0]) || pos[3].equals(pos[1]) || pos[3].equals(pos[2])){
                pos[3] = WindowPos.values()[(int) (Math.random() * 10)];
            }else {
                samePos = false;
            }
        }

    }
}
