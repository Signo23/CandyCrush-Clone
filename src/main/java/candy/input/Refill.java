package candy.input;

import java.util.Map;
import java.util.Optional;

import candy.common.Position;
import candy.model.game.level.grid.table.Table;
import candy.model.game.level.grid.table.TableBuilder;
import candy.model.game.level.grid.table.TableBuilderImpl;
import candy.model.game.level.grid.table.candy.Candy;
import candy.model.game.level.grid.table.candy.CandyTypes;

public class Refill {
    private final TableBuilder tableBuilder = new TableBuilderImpl();

    /**
     * Scroll down the candies to replace empty spaces, then generate random candies where is necessary.
     * @param table
     */
    public final void scrollDown(final Table table) {

        final Map<Position, Optional<Candy>> grid = table.getGrid();
        final int nRows = table.getRows();
        final int nColumns = table.getColumns();
        int k;

        for (int i = nRows - 1; i > 0; i--) {
            for (int j = 0; j < nColumns; j++) {
                final Position pos = new Position(i, j);
                while (grid.get(pos).isEmpty()) {
                    for (k = i; k > 0; k--) {
                        final Position substituteCandy = new Position(k - 1, j);
                        if (grid.get(substituteCandy).get().getCandyType().equals(Optional.of(CandyTypes.EMPTY))) {
                            break;
                        } else {
                            grid.put(new Position(k, j), grid.get(substituteCandy));
                        }
                    }
                    grid.put(new Position(k, j), Optional.of(tableBuilder.getRandomNormalCandy(table.getColorsSet())));
                }
            }
        }
        for (int j = 0; j < nColumns; j++) {
            final Position pos = new Position(0, j);
            if (grid.get(pos).isEmpty()) {
                grid.put(new Position(0, j), Optional.of(tableBuilder.getRandomNormalCandy(table.getColorsSet())));
            }
        }
    }

}
