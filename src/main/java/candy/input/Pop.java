package candy.input;

import java.util.List;

import candy.common.Position;
import candy.model.game.level.grid.table.Table;

public interface Pop {

    /**
     * If there is a special combination, generate a Special Candy, then remove the other candies in List positions.
     * @param positions
     * @param switchedPosition
     * @param grid
     */
    void pop(List<Position> positions, Position switchedPosition, Table grid);
    /**
     * Remove a list of candies, setting value at Optional.empty().
     * @param positions
     * @param grid
     */
    void removeCandy(List<Position> positions, Table grid);
}
