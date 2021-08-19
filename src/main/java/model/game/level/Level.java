package model.game.level;

import java.util.Optional;

import model.game.level.grid.Grid;

public interface Level {
    /**
     * Gives the {@link Grid} of the {@link Level}.
     * @return the {@link Grid} of the {@link Level}.
     */
    Grid getGrid();
    /**
     * Gives the {@link LevelTypes} of the {@link Level}.
     * @return the {@link LevelTypes} of the {@link Level}.
     */
    LevelTypes getType();
    /**
     * Gives the number of moves of the {@link Level}.
     * @return the number of moves of the {@link Level}.
     */
    Optional<Integer> getMoves();
    /**
     * Gives the number of seconds for terminate the {@link Level}.
     * @return the number of seconds for terminate the {@link Level}.
     */
    Optional<Integer> getTime();
}
