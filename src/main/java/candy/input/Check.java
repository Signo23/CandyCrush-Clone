package candy.input;

import java.util.List;

import model.game.level.grid.table.Table;
import other.Pair;

public interface Check {

    /**
     * Control if there is a combination of candies.
     * @param position
     * @param grid
     * @return the List<Pair> of the positions of the candies to remove or an empty List<Pair>
     */
    List<Pair> checkMatch(Pair position, Table grid);

}
