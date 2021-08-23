package candy.model.game.level.grid;

import java.util.Map;
import java.util.Optional;

import candy.common.Pair;
import candy.model.game.level.grid.table.candy.Candy;

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
    Optional<String> getStartingMessage();
    /**
     * Gives the ending message of the {@link Grid}.
     * @return the ending message of the {@link Grid}.
     */
    Optional<String> getEndingMessage();
    /**
     * Gives the grid of the {@link Grid}.
     * @return the grid of the {@link Grid}.
     */
    Map<Pair, Candy> getGrid();
}
