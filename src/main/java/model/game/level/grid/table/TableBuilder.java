package model.game.level.grid.table;

import java.util.Set;

import other.Pair;
import model.game.level.grid.table.candy.Candy;
import model.game.level.grid.table.candy.CandyColors;

public interface TableBuilder {
    /**
     * Allows to set the dimensions of the Table.
     * 
     * @param rows
     *       The height of the Table expressed as number of cells.
     * @param columns
     *       The width of the Table expressed as number of cells. 
     * @throws IllegalArgumentException
     *       If negative or zero values are passed.
     */
    void setDimensions(int rows, int columns);
    /**
     * Allows to modify the structure of the table.
     * 
     * @param positions
     *       The positions of all empty candy in the table.
     */
    void setEmptyCells(Set<Pair> positions);
    /**
     * Allows to choose the candy color in the table.
     * 
     * @param colors
     *       The list of all available colors.
     */
    void setAvailableColor(Set<CandyColors> colors);
    /**
     * Fill the table with random candies.
     *
     */
    void setCandies();
   /* 
    void checkTable(); */
    /**
     * Build the table.
     * 
     * @return
     *          An object implementing the {@link Table} interface.
     * @throws IllegalStateException
     *          If trying to build the same {@link Table} twice,
     *          if no dimension is set,
     *          if no empty candy is set, even if there are no empty candy to set.
     *          if no available color is set.
     *          if the grid is not full.
     */
    Table build(); 
    /**
     * Generate a random normal candy.
     * 
     * @param colorSet
     *       The list of all available colors.
     * @return
     *       This instance of {@link TableBuilder}.
     */
    Candy getRandomNormalCandy(Set<CandyColors> colorSet);
}
