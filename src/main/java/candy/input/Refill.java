package candy.input;

import java.util.Map;
import java.util.Optional;

import model.game.level.grid.table.candy.CandyTypes;
import model.game.level.grid.table.Table;
import model.game.level.grid.table.TableBuilder;
import model.game.level.grid.table.TableBuilderImpl;
import model.game.level.grid.table.candy.Candy;
import other.Pair;

public class Refill {
    private final TableBuilder tableBuilder = new TableBuilderImpl();

    /**
     * Scroll down the candies to replace empty spaces, then generate random candies where is necessary.
     * @param table
     */
    public final void scrollDown(final Table table) {

        final Map<Pair, Optional<Candy>> grid = table.getGrid();
        final int nRows = table.getRows();
        final int nColumns = table.getColumns();
        int k;

        for (int i = nRows - 1; i > 0; i--) {
            for (int j = 0; j < nColumns; j++) {
                final Pair pos = new Pair(i, j);
                while (grid.get(pos).isEmpty()) {
                    for (k = i; k > 0; k--) {
                        final Pair substituteCandy = new Pair(k - 1, j);
                        if (grid.get(substituteCandy).get().getCandyType().equals(Optional.of(CandyTypes.EMPTY))) {
                            break;
                        } else {
                            grid.put(new Pair(k, j), grid.get(substituteCandy));
                        }
                    }
                    grid.put(new Pair(k, j), Optional.of(tableBuilder.getRandomNormalCandy(table.getColorsSet())));
                }
            }
        }
        for (int j = 0; j < nColumns; j++) {
            final Pair pos = new Pair(0, j);
            if (grid.get(pos).isEmpty()) {
                grid.put(new Pair(0, j), Optional.of(tableBuilder.getRandomNormalCandy(table.getColorsSet())));
            }
        }
    }

}
