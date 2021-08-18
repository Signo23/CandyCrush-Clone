package candy.input;

import java.util.List;

import model.game.level.grid.table.Table;
import other.Pair;

public interface Pop {

    /**
     * If there is a special combination, generate a Special Candy, then remove the other candies in List positions.
     * @param positions
     * @param switchedPosition
     * @param grid
     */
    void pop(List<Pair> positions, Pair switchedPosition, Table grid);
    /**
     * Remove a list of candies, setting value at Optional.empty().
     * @param positions
     * @param grid
     */
    void removeCandy(List<Pair> positions, Table grid);
}
