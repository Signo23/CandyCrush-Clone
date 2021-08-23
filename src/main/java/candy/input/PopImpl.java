package candy.input;

import java.util.List;
import java.util.Optional;

import candy.common.Position;
import candy.model.game.level.grid.table.Table;
import candy.model.game.level.grid.table.candy.CandyColors;
import candy.model.game.level.grid.table.candy.CandyTypes;

public class PopImpl implements Pop {

    private static final int POP_FROM_FOUR = 4;
    private static final int POP_FROM_FIVE = 5;


    public final void pop(final List<Position> positions, final Position switchedPosition, final Table grid) {
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

    public final void removeCandy(final List<Position> positions, final Table grid) {
        for (final Position pos : positions) {
            if (!(grid.getGrid().get(pos).get().getCandyType().equals(Optional.of(CandyTypes.EMPTY)))) {
                grid.getGrid().put(pos, Optional.empty());
            }
        }
    }

}
