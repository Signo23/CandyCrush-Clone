package candy.input;

import java.util.List;
import java.util.Optional;

import model.game.level.grid.table.candy.CandyTypes;
import model.game.level.grid.table.candy.CandyColors;
import model.game.level.grid.table.Table;
import other.Pair;

public class PopImpl implements Pop {

    private static final int POP_FROM_FOUR = 4;
    private static final int POP_FROM_FIVE = 5;


    public final void pop(final List<Pair> positions, final Pair switchedPosition, final Table grid) {
        if (positions.size() == POP_FROM_FOUR) {
            grid.getGrid().get(switchedPosition).get().setCandyType(Optional.of(CandyTypes.HORIZONTAL_STRIPED));
            positions.remove(switchedPosition);
        } else if (positions.size() == POP_FROM_FIVE) {
            grid.getGrid().get(switchedPosition).get().setCandyType(Optional.of(CandyTypes.BOMB));
            grid.getGrid().get(switchedPosition).get().setCandyColor(Optional.of(CandyColors.COLOR_BOMB));
            positions.remove(switchedPosition);
        }
        removeCandy(positions, grid);
    }

    public final void removeCandy(final List<Pair> positions, final Table grid) {
        for (final Pair pos : positions) {
            if (!(grid.getGrid().get(pos).get().getCandyType().equals(Optional.of(CandyTypes.EMPTY)))) {
                grid.getGrid().put(pos, Optional.empty());
            }
        }
    }

}
