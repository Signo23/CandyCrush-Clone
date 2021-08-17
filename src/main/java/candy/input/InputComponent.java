package candy.input;

import model.game.level.table.Table;
import other.Pair;

public interface InputComponent {

    /**
     * Update the grid after check if there is a combination of candies.
     * @param position
     * @param ctrl
     * @param grid
     */
    void update(Pair position, InputController ctrl, Table grid);

}
