package org.academia.carcrash.simplegfx;

import org.academia.carcrash.grid.GridColor;
import org.academia.carcrash.grid.GridDirection;
import org.academia.carcrash.grid.position.AbstractGridPosition;
import org.academia.carcrash.grid.position.GridPosition;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Simple graphics position
 */
public class SimpleGfxGridPosition extends AbstractGridPosition {

    private Rectangle rectangle;
    private SimpleGfxGrid simpleGfxGrid;

    /**
     * Simple graphics position constructor
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(SimpleGfxGrid grid){
        super((int) (Math.random() * grid.getCols()), (int) (Math.random() * grid.getRows()), grid);

        this.simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.columnToX(super.getCol()) + SimpleGfxGrid.PADDING ,grid.rowToY(super.getRow())+ SimpleGfxGrid.PADDING,grid.getCellSize(),grid.getCellSize());
        rectangle.draw();
    }

    /**
     * Simple graphics position constructor
     * @param col position column
     * @param row position row
     * @param grid Simple graphics grid
     */
    public SimpleGfxGridPosition(int col, int row, SimpleGfxGrid grid){
        super(col, row, grid);

        this.simpleGfxGrid = grid;
        this.rectangle = new Rectangle(grid.columnToX(super.getCol()) + SimpleGfxGrid.PADDING ,grid.rowToY(super.getRow())+ SimpleGfxGrid.PADDING,grid.getCellSize(),grid.getCellSize());
        rectangle.draw();
    }


    /**
     * @see GridPosition#show()
     */
    @Override
    public void show() {
        rectangle.fill();
    }

    /**
     * @see GridPosition#hide()
     */
    @Override
    public void hide() {
      rectangle.delete();
    }

    /**
     * @see GridPosition#moveInDirection(GridDirection, int)
     */
    @Override
    public void moveInDirection(GridDirection direction, int distance) {
        super.moveInDirection(direction, distance);

        switch (direction){
            case UP:
                rectangle.translate(0, (simpleGfxGrid.getCellSize() * super.getRow()) - rectangle.getY()+ SimpleGfxGrid.PADDING);
                break;
            case DOWN:
                rectangle.translate(0, (simpleGfxGrid.getCellSize() * super.getRow()) - rectangle.getY()+ SimpleGfxGrid.PADDING);
                break;
            case LEFT:
                rectangle.translate((simpleGfxGrid.getCellSize() * super.getCol()) - rectangle.getX() + SimpleGfxGrid.PADDING, 0);
                break;
            case RIGHT:
                rectangle.translate((simpleGfxGrid.getCellSize() * super.getCol()) - rectangle.getX()+ SimpleGfxGrid.PADDING, 0);

                break;
        }
    }

    /**
     * @see AbstractGridPosition#setColor(GridColor)
     */
    @Override
    public void setColor(GridColor color) {

        switch (color){

            case RED:
                rectangle.setColor(Color.RED);
                super.setColor(GridColor.RED);
                break;
            case GREEN:
                rectangle.setColor(Color.GREEN);
                super.setColor(GridColor.GREEN);
                break;
            case BLUE:
                rectangle.setColor(Color.BLUE);
                super.setColor(GridColor.BLUE);
                break;
            case MAGENTA:
                rectangle.setColor(Color.MAGENTA);
                super.setColor(GridColor.MAGENTA);
                break;
            case NOCOLOR:
                super.setColor(GridColor.NOCOLOR);
                break;
        }

    }

    @Override
    public GridColor getColor() {
        return super.getColor();
    }
}
