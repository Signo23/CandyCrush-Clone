package candy.model.game.level.grid;

import candy.model.game.level.grid.table.Table;

public interface GridBuilder {
    /**
     * Allows to set a {@link Table} for the {@link Grid}.
     * 
     * @param table
     *        The {@link Table} to be set.
     */
    void setTable(Table table);
    /**
     * Allows to set a {@link Controller} for the {@link Grid}.
     * 
     * @param controller
     *        The {@link Controller} to be set.
     */
    void setController(Controller controller);
    /**
     * Allows to set the {@link Grid}'s objective.
     * 
     * @param objective
     *        The {@link Objective} to be set.
     */
    void setObjective(Objective objective);

    /**
     * Allows to set the starting message of the {@link Grid}.
     * 
     * @param startMsg
     *          The message to be printed.
     */
    void setStartingMessage(String startMsg);
    /**
     * Allows to set a message that needs to be shown after the end of this {@link Grid}.
     * 
     * @param endMsg
     *          The message to be printed.
     */
    void setEndingMessage(String endMsg);
    /**
     * Check if the table have moves, if is true, the table is 
     * updated until there are any moves in the grid.
     *
     **/
    void checkTable(); 
    /**
     * Build the grid.
     * 
     * @return
     *          An object implementing the {@link Level} interface.
     * @throws IllegalStateException
     *          If trying to build the same {@link Grid} twice,
     *          if no {@link Table} is set
     *          if no {@link Objective} is set,
     *          if no {@link Controller} is set.
     *          if no {@link startingMessage} is set.
     *          if no {@link endingMessage} is set.
     */
    Grid build();
	

}
