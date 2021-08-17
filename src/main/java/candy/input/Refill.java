package candy.input;

import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.table.Table;
import model.game.level.table.TableBuilder;
import model.game.level.table.TableBuilderImpl;
import other.Pair;

public class Refill {
    private final TableBuilder tableBuilder = new TableBuilderImpl();
    public final void scrollDown(final Table table) {

        final Map<Pair, Optional<Candy>> grid = table.getGrid();
        final int nRows = table.getRows();
        final int nColumns = table.getColumns();

        for (int i = nRows - 1; i > 0; i--) {
            for (int j = 0; j < nColumns; j++) {
                final Pair pos = new Pair(i, j);
                if (grid.get(pos).isEmpty()) {
                    while (grid.get(pos).isEmpty()) {
                        for (int k = i; k > 0; k--) {
                            final Pair substituteCandy = new Pair(k - 1, j);
                            grid.put(new Pair(k, j), grid.get(substituteCandy));
                        }
                        grid.put(new Pair(0, j), tableBuilder.getRandomNormalCandy(table.getColors()));
                     }
                }
            }
        }
    }

}
