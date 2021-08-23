package candy.input;

import java.util.ArrayList;
import java.util.List;

import candy.common.Position;
import candy.model.Candy;
import candy.model.Grid;

public class SimpleCheck {

    private static final int MIN_DIM = 3;
    private static final int NEXT = 1;
    private static final int PREC = -1;
    private static final int NO_INC = 0;

    public final List<Position> checkMatch(final Position position, final Grid grid) {
        final List<Position> result = new ArrayList<>();
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
            for (final Position elem : result) {
                if (grid.getCandies().get(elem).getType().equals(Candy.Type.STRIPED)) {
                     final double i = elem.getX();
                     final int ncolumns = grid.getColumn();
                     for (int j = 0; j < ncolumns; j++) {
                         final Position pos = new Position(i, j);
                         result.add(pos);
                     }
                }
            }
            return result;
        }
        result.clear();
        return result;
    }

    private void controll(final Position pos, final List<Position> result, final int incX, final int incY, final Grid grid) {
        final Position next = new Position(pos.getX() + incX, pos.getY() + incY);
        final Candy.Color nextColor = grid.getCandies().get(next).getColor();
        if (grid.getCandies().get(pos).getColor().equals(nextColor)) {
            result.add(next);
            controll(next, result, incX, incY, grid);
        }
    }

}
