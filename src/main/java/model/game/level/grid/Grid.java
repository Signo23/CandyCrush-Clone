package model.game.level.grid;

import java.util.Map;

import model.game.level.grid.candy.Candy;
import other.Pair;

public interface Grid {

    /**
     * Gives the objective of the {@link Grid}.
     * @return the objective of the {@link Grid}.
     */
    Objective getObjective();
    
    /**
     * Gives the controller of the {@link Grid}.
     * @return the controller of the {@link Grid}.
     */
    Controller getController();

    /**
     * Gives the starting message of the {@link Grid}.
     * @return the starting message of the {@link Grid}.
     */
    String getStartingMessage();

    /**
     * Gives the ending message of the {@link Grid}.
     * @return the ending message of the {@link Grid}.
     */
    String getEndingMessage();

    /**
     * Gives the grid of the {@link Grid}.
     * @return the grid of the {@link Grid}.
     */
    Map<Pair,Candy> getGrid();
}
