package model.game.level.table;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;
import other.Pair;

public interface Table {
    /**
     * Gives the rows of the {@link Table}.
     * @return the {@link rows} of the {@link Table}.
     */
    int getRows();
    /**
     * Set the rows of the {@link Table}.
     * @param rows The rows of the {@link Table}.
     */
    void setRows(int rows);
    /**
     * Gives the columns of the {@link Table}.
     * @return the {@link columns} of the {@link Table}.
     */
    int getColumns(); 
    /**
     * Set the columns of the {@link Table}.
     * @param columns The columns of the {@link Table}.
     */
    void setColumns(int columns);
    /**
     * Gives the color in the grid of candies of the {@link Candy} as a List.
     * @return the List of color in the grid of candies of the {@link Candy}.
     */
    List<CandyColors> getColors(); 
    /**
     * Gives the color in the grid of candies of the {@link Candy} as a Set.
     * @return the Set of color in the grid of candies of the {@link Candy}.
     */
    Set<CandyColors> getColorsSet();
    /**
     * Set the List of colors available in the {@link Table}.
     * @param colors set of color available in the {@link Table}.
     */
    void setColors(List<CandyColors> colors);
    /**
     * Gives the grid of candies of the {@link Candy}.
     * @return the gird of candies of the {@link Candy}.
     */
    Map<Pair, Optional<Candy>> getGrid();
}
