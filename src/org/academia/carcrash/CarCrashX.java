package org.academia.carcrash;

import org.academia.carcrash.grid.GridType;

public class CarCrashX {

    public void init() {

        Game g = new Game(GridType.SIMPLE_GFX, 64, 39, 200);

        g.init();
        try {
            g.start();
        } catch (InterruptedException e) {
        }

    }

}
