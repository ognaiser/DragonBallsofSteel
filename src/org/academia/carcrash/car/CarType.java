package org.academia.carcrash.car;

import org.academia.carcrash.grid.GridColor;

/**
 * Different types of cars
 */
public enum CarType {

    FIAT(GridColor.BLUE),
    MUSTANG(GridColor.GREEN),
    Special(GridColor.MAGENTA);


    private GridColor color;

    /**
     * Constructor of Car Types
     * @param color The car type color
     */
    CarType(GridColor color) {
        this.color = color;
    }

    /**
     * Obtain the getColor associated with each car type
     *
     * @return the grid getColor
     */
    public GridColor getColor() {

        return this.color;

    }
}
