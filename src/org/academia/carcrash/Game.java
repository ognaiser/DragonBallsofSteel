package org.academia.carcrash;

import org.academia.carcrash.car.Car;
import org.academia.carcrash.car.CarFactory;
import org.academia.carcrash.car.SpecialCar;
import org.academia.carcrash.grid.Grid;
import org.academia.carcrash.grid.GridFactory;
import org.academia.carcrash.grid.GridType;
import org.academiadecodigo.simplegraphics.graphics.Text;


/**
 * The game logic
 */
public class Game {


    /**
     * Graphical Car field
     */
    private Grid grid;

    /**
     * Container of Cars
     */
    private Car[] cars;

    /**
     * Animation delay
     */
    private int delay;

    /**
     * The collision detector
     */
    private CollisionDetector collisionDetector;

    /**
     * Number of cars to manufacture
     */
    private int manufacturedCars = 40;

    private boolean gameOver = false;

    private Text win;

    /**
     * Constructs a new game
     *
     * @param gridType which grid type to use
     * @param cols     number of columns in the grid
     * @param rows     number of rows in the grid
     * @param delay    animation delay
     */
    Game(GridType gridType, int cols, int rows, int delay) {

        grid = GridFactory.makeGrid(gridType, cols, rows);
        this.delay = delay;

    }

    /**
     * Creates a bunch of cars and randomly puts them in the field
     */
    public void init() {

        grid.init();

        cars = new Car[manufacturedCars];
        collisionDetector = new CollisionDetector(cars);


        cars[0] = new SpecialCar(grid.makeGridPosition());
        cars[0].setCollisionDetector(collisionDetector);
        cars[0].setGrid(grid);

        for (int i = 1; i < manufacturedCars; i++) {

            cars[i] = CarFactory.getNewCar(grid);
            cars[i].setCollisionDetector(collisionDetector);
            cars[i].setGrid(grid);

        }

    }

    /**
     * Starts the animation
     *
     * @throws InterruptedException
     */
    public void start() throws InterruptedException {

        while (!gameOver) {

            // Pause for a while
            Thread.sleep(delay);

            moveAllCars();

            checkEndgame();

        }

        Thread.sleep(3000);

        win.delete();
    }

    /**
     * Moves all cars
     */
    public void moveAllCars() {

        for (Car c : cars) {
            c.move();
            collisionDetector.check(c);
        }

    }

    private void checkEndgame() {

        if (cars[0].isCrashed()) {
            gameOver = true;

            win = new Text(660, 390, "YOU LOSE");
            win.grow(70, 70);
            win.draw();


        }

        int count = 0;

        for (int i = 1; i < cars.length; i++) {
            if (cars[i].isCrashed()) {
                count++;
            }
        }

        if (count == cars.length - 1) {
            gameOver = true;

            win = new Text(660, 390, "YOU WI");
            win.grow(70, 70);
            win.draw();


        }

    }

}
