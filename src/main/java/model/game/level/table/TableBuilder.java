package model.game.level.table;

import java.util.List;
import java.util.Set;

import other.Pair;
import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;

public interface TableBuilder {
	
	  /**
     * Allows to set the dimensions of the Table.
     * 
     * @param rows
     *       The height of the Table expressed as number of cells.
     * @param columns
     *       The width of the Table expressed as number of cells.
     * @return
     *       This instance of {@link TableBuilder}. 
     * @throws IllegalArgumentException
     *       If negative or zero values are passed.
     */
	TableBuilder setDimensions(int rows, int columns);
	
	 /**
     * Allows to modify the structure of the table.
     * 
     * @param positions
     *       The positions of the empty candy in the table.      
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder setEmptyCells(Set<Pair> positions);
	
	/**
     * Allows to choose the candy color in the table.
     * 
     * @param colors
     *       The list of all available colors.
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder setAvailableColor(Set<CandyColors> colors);
	
	/**
     * Fill the table with random candies.
     * 
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder setCandies();
	
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
