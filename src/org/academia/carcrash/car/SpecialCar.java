package org.academia.carcrash.car;

import org.academia.carcrash.grid.position.GridPosition;

public class SpecialCar extends Car {

    /**
     * Constructs a new car
     *
     * @param pos     the initial car position
     *
     */

    SpecialCarHandler specialCarHandler;

    public SpecialCar(GridPosition pos) {
        super(pos, CarType.Special);
        specialCarHandler = new SpecialCarHandler(this);

    }



    @Override
    public void move() {

    }

    @Override
    public void crash() {
        super.crash();
        specialCarHandler.deleteHandlers();
    }
}
