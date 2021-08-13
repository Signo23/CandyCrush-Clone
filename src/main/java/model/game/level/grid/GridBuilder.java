package model.game.level.grid;

import java.util.Set;

import model.game.level.grid.candy.CandyColors;

public interface GridBuilder {
	/**
     * Allows to set the dimensions of the {@link Stage}'s grid.
     * 
     * @param height
     *       The height of the {@link Stage} expressed as number of cells.
     * @param width
     *       The width of the {@link Stage} expressed as number of cells.
     *       
     * @return
     *       This instance of {@link StageBuilder}.
     *       
     * @throws IllegalArgumentException
     *       If negative or zero values are passed.
     */
    GridBuilder setDimensions(final int width, final int height);
    
    /**
     * Allows to set a {@link Controller} for the current {@link StageBuilder}.
     * 
     * @return
     *       This instance of {@link StageBuilder}.
     */
    GridBuilder setController(final Controller controller);
    
    /**
     * Allows to set some specific cells of the grid as empty and unusable.
     * 
     * @param positions
     *       The Set of all the positions (x,y) to be set as empty.
     *       
     * @return
     *       This instance of {@link StageBuilder}.
     *       
     * @throws NullPointerException
     *       If positions is null.
     * @throws IllegalStateException
     *       If grid has not been set.
     */
    GridBuilder setEmptyCells(final Set<Pair<Integer,Integer>> positions);
    
    /**
     * Allows to set the {@link Stage}'s objective.
     * 
     * @param newObjective
     *        The new {@link Objective} to be set.
     *        
     * @return
     *       This instance of {@link StageBuilder}.
     */
    GridBuilder setObjective(final Objective newObjective);
    
    /**
     * Allows to add an available {@link CandyColors} for the {@link Stage}.
     * 
     * @param newColor
     *          The new available {@link CandyColors}.
     *          
     * @return
     *          This instance of {@link StageBuilder}.
     */
    GridBuilder addAvailableColor(final CandyColors newColor);
    
    /**
     * Allows to set specific candies in specific positions.
     * 
     * @param candies
     *          A Map telling which {@link Candy} is in each position.
     *          
     * @return
     *          This instance of {@link StageBuilder}.
     * 
     * @throws IllegalArgumentException
     *          If at least one position is not set
     *          or
     *          if at least one position is already mapped to a candy.
     */
    GridBuilder setCandies(final Map<Pair<Integer,Integer>, Candy> candies);
    
    /**
     * Allows to set a message that needs to be shown at the beginning of this {@link Stage}.
     * 
     * @param startMsg
     *          The message to be printed.
     *          
     * @return
     *          This instance of {@link StageBuilder}.
     */
    GridBuilder setStartingMessage(final String startMsg);
    
    /**
     * Allows to set a message that needs to be shown after the end of this {@link Stage}.
     * 
     * @param endMsg
     *          The message to be printed.
     *          
     * @return
     *          This instance of {@link StageBuilder}.
     */
    GridBuilder setEndingMessage(final String endMsg);
    
    /**
     * This call ends the {@link Stage}'s building process.
     * 
     * @return
     *          An object implementing the {@link Stage} interface.
     *          
     * @throws IllegalStateException
     *          If trying to build the same {@link Stage} twice,
     *          if {@link Stage}'s grid isn't set,
     *          if no {@link CandyColors} are set,
     *          if grid is filled with {@link CandyColors.CHOCOLATE},
     *          if both jelly and {@link CandyColors.CHOCOLATE} are present,
     *          if at least one {@link Candy} is in the same position of one {@link CandyColors.CHOCOLATE} piece,
     *          if no {@link Objective} is set,
     *          if no {@link Controller} is set.
     */
    GridBuilder build();
	

}
