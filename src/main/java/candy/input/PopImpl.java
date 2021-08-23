package candy.input;

import java.util.List;

import candy.common.Position;
import candy.model.Candy;
import candy.model.Grid;

public class PopImpl implements Pop {

    private static final int POP_FROM_FOUR = 4;
    private static final int POP_FROM_FIVE = 5;


    public final void pop(final List<Position> positions, final Position switchedPosition, final Grid grid) {
        if (positions.size() == POP_FROM_FOUR) {
            grid.getCandies().get(switchedPosition).setType(Candy.Type.STRIPED);
            positions.remove(switchedPosition);
        } else if (positions.size() == POP_FROM_FIVE) {
            grid.getCandies().get(switchedPosition).setType(Candy.Type.BOMB);
            grid.getCandies().get(switchedPosition).setColor(Candy.Color.NULL);
            positions.remove(switchedPosition);
        }
        removeCandy(positions, grid);
    }

    public final void removeCandy(final List<Position> positions, final Grid grid) {
        for (final Position pos : positions) {
            if (!(grid.getCandies().get(pos).getType().equals(Candy.Type.EMPTY))) {
                grid.getCandies().get(pos).setType(Candy.Type.NULL);
            }
        }
    }

}
