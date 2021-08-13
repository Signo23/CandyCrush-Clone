package model.game.level.grid;

import java.util.Set;

import model.game.level.grid.candy.CandyColors;

public interface GridBuilder {
    
    /**
     * Allows to set a {@link Controller} for the {@link Grid}.
     * 
     * @return
     *       This instance of {@link GridBuilder}.
     */
    GridBuilder setController(final Controller controller);
    
    /**
     * Allows to set the {@link Grid}'s objective.
     * 
     * @param objective
     *        The {@link Objective} to be set.
     *        
     * @return
     *       This instance of {@link GridBuilder}.
     */
    GridBuilder setObjective(final Objective objective);

    /**
     * Allows to set the starting message of the {@link Grid}.
     * 
     * @param startMsg
     *          The message to be printed.
     *          
     * @return
     *          This instance of {@link GridBuilder}.
     */
    GridBuilder setStartingMessage(final String startMsg);
    
    /**
     * Allows to set a message that needs to be shown after the end of this {@link Grid}.
     * 
     * @param endMsg
     *          The message to be printed.
     *          
     * @return
     *          This instance of {@link GridBuilder}.
     */
    GridBuilder setEndingMessage(final String endMsg);
    
    /**
     * Build the grid.
     * 
     * @return
     *          An object implementing the {@link Level} interface.
     *          
     * @throws IllegalStateException
     *          If trying to build the same {@link Grid} twice,
     *          if no {@link Objective} is set,
     *          if no {@link Controller} is set.
     */
    GridBuilder build();
	

}
