package model.game.level.table;

import java.awt.geom.Point2D;
import java.util.List;
import java.util.Map;
import java.util.Set;

import other.Pair;
import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;

public interface TableBuilder {
	
	  /**
     * Allows to set the dimensions of the Table.
     * 
     * @param height
     *       The height of the Table expressed as number of cells.
     * @param width
     *       The width of the Table expressed as number of cells.
     *       
     * @return
     *       This instance of {@link TableBuilder}.
     *       
     * @throws IllegalArgumentException
     *       If negative or zero values are passed.
     */
	TableBuilder setDimensions(int width, int height);
	
	 /**
     * Allows to modify the structure of the table.
     * 
     * @param positions
     *       The positions of the empty candy in the table.      
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder setEmptyCells(Set<Pair<Integer,Integer>> positions);
	
	/**
     * Allows to choose the candy color in the table.
     * 
     * @param color
     *       The positions of the empty candy in the table.
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder addAvailableColor(CandyColors color);
	
	/**
     * Fill the table with random candies.
     * 
     * @param colors 
     * @return
     *       This instance of {@link TableBuilder}.
     */
	TableBuilder setCandies(List<CandyColors> colors);
	
	TableBuilder build(); 
	
	/**
     * Generate a candy rhi
     * 
     * @param colors
     * 
     * @return
     *       This instance of {@link TableBuilder}.
     */
	Candy getRandomNormalCandy(List<CandyColors> colors);
}
