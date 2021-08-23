package candy.input;

import java.util.List;

import candy.common.Position;
import candy.model.game.level.grid.table.Table;

public interface Check {

    /**
     * Control if there is a combination of candies.
     * @param position
     * @param grid
     * @return the List<Pair> of the positions of the candies to remove or an empty List<Pair>
     */
    List<Position> checkMatch(Position position, Table grid);

}
