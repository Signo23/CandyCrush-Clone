package candy.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import candy.common.Pair;
import candy.model.game.level.grid.table.Table;
import candy.model.game.level.grid.table.candy.CandyColors;
import candy.model.game.level.grid.table.candy.CandyTypes;

public class CompleteCheck extends SimpleCheck implements Check {

    public final List<Pair> completeCheck(final Pair actualPos, final Pair oldPos, final Table grid) {
        final List<Pair> result = new ArrayList<>();
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
    private List<Pair> bombCheck(final Pair actualPos, final Pair oldPos, final Table grid) {
        final int nrows = grid.getRows();
        final int ncolumns = grid.getColumns();
        final List<Pair> res = new ArrayList<>();
        final Optional<CandyTypes> typeRef = grid.getGrid().get(oldPos).get().getCandyType();
        final Optional<CandyColors> colorRef = grid.getGrid().get(oldPos).get().getCandyColor();
        if (grid.getGrid().get(actualPos).get().getCandyType().equals(Optional.of(CandyTypes.BOMB))) {
            for (int i = 0; i < nrows; i++) {
                for (int j = 0; j < ncolumns; j++) {
                    final Pair pos = new Pair(i, j);
                    if (grid.getGrid().get(pos).get().getCandyType().equals(typeRef) 
                        && grid.getGrid().get(pos).get().getCandyColor().equals(colorRef)) {
                        res.add(pos);
                    }
                }
            }
        }
        return res;
    }
}
