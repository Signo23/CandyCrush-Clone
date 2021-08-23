package candy.input;

import java.util.ArrayList;
import java.util.List;

import candy.common.Position;
import candy.model.Candy;
import candy.model.Grid;
public class CompleteCheck extends SimpleCheck {

    public final List<Position> completeCheck(final Position actualPos, final Position oldPos, final Grid grid) {
        final List<Position> result = new ArrayList<>();
        result.addAll(bombCheck(actualPos, oldPos, grid));
        if (result.isEmpty()) {
            checkMatch(actualPos, grid);
        }
        return result;
    }

    /**
     * Control if there is a Color Bomb combination.
     * @param actualPos
     * @param oldPos
     * @param grid
     * @return the List<Pair> with the positions of the candies to remove or an Empty List<Pair>
     */
    private List<Position> bombCheck(final Position actualPos, final Position oldPos, final Grid grid) {
        final int nrows = grid.getRow();
        final int ncolumns = grid.getColumn();
        final List<Position> res = new ArrayList<>();
        final Candy.Type typeRef = grid.getCandies().get(oldPos).getType();
        final Candy.Color colorRef = grid.getCandies().get(oldPos).getColor();
        if (grid.getCandies().get(actualPos).getType().equals(Candy.Type.BOMB)) {
            for (int i = 0; i < nrows; i++) {
                for (int j = 0; j < ncolumns; j++) {
                    final Position pos = new Position(i, j);
                    if (grid.getCandies().get(pos).getType().equals(typeRef) 
                        && grid.getCandies().get(pos).getColor().equals(colorRef)) {
                        res.add(pos);
                    }
                }
            }
        }
        return res;
    }
}
