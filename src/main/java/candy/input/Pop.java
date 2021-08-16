package candy.input;

import java.util.List;
import java.util.Optional;

import model.game.level.grid.candy.CandyColors;
import model.game.level.grid.candy.CandyTypes;
import model.game.level.table.Table;
import other.Pair;

public class Pop {

    private static final int POP_FROM_FOUR = 4;
    private static final int POP_FROM_FIVE = 5;


    public final void removeCandy(final List<Pair> positions, final Pair switchedPosition, final Table grid) {

        for (final Pair pos : positions) {
            grid.getGrid().get(pos);
            Optional.empty();
        }
        if (positions.size() == POP_FROM_FOUR) {
            grid.getGrid().get(switchedPosition).get().setCandyType(CandyTypes.HORIZONTAL_STRIPED);
        } else if (positions.size() == POP_FROM_FIVE) {
            grid.getGrid().get(switchedPosition).get().setCandyType(CandyTypes.BOMB);
        }
    }

}
