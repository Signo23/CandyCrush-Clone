package candy.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import candy.model.game.level.grid.table.Table;
import candy.model.game.level.grid.table.candy.CandyColors;
import candy.model.game.level.grid.table.candy.CandyTypes;
import other.Pair;

public class SimpleCheck implements Check {

    private static final int MIN_DIM = 3;
    private static final int NEXT = 1;
    private static final int PREC = -1;
    private static final int NO_INC = 0;

    public final List<Pair> checkMatch(final Pair position, final Table grid) {
        final List<Pair> result = new ArrayList<>();
        int incX = NO_INC;
        int incY = PREC;
        result.add(position);
        controll(position, result, incX, incY, grid);
        incY = NEXT;
        controll(position, result, incX, incY, grid);
        if (result.size() < MIN_DIM) {
            result.clear();
            result.add(position);
            incX = PREC;
            incY = NO_INC;
            controll(position, result, incX, incY, grid);
            incY = NEXT;
            controll(position, result, incX, incY, grid);
        }
        if (result.size() >= MIN_DIM) {
            for (final Pair elem : result) {
                if (grid.getGrid().get(elem).get().getCandyType().equals(Optional.of(CandyTypes.HORIZONTAL_STRIPED))) {
                     final double i = elem.getX();
                     final int ncolumns = grid.getColumns();
                     for (int j = 0; j < ncolumns; j++) {
                         final Pair pos = new Pair(i, j);
                         result.add(pos);
                     }
                }
            }
            return result;
        }
        result.clear();
        return result;
    }

    private void controll(final Pair pos, final List<Pair> result, final int incX, final int incY, final Table grid) {
        final Pair next = new Pair(pos.getX() + incX, pos.getY() + incY);
        final Optional<CandyColors> nextColor = grid.getGrid().get(next).get().getCandyColor();
        if (grid.getGrid().get(pos).get().getCandyColor().equals(nextColor)) {
            result.add(next);
            controll(next, result, incX, incY, grid);
        }
    }

}
