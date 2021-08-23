package candy.model.game.level.grid.table;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import candy.common.Pair;
import candy.model.game.level.grid.table.candy.Candy;
import candy.model.game.level.grid.table.candy.CandyColors;

public class TableImpl implements Table {
    private Map<Pair, Optional<Candy>> grid;
    private List<CandyColors> colors;
    private int rows;
    private int columns;

    public TableImpl(final Map<Pair, Optional<Candy>> grid, final Set<CandyColors> colorSet, final int row,
            final int column) {
        this.grid = grid;
        final List<CandyColors> col = new LinkedList<>();
        for (final CandyColors cc : colorSet) {
            col.add(cc);
        }
        this.colors = col;
        this.setRows(row);
        this.columns = column;
    }

    public final int getRows() {
        return rows;
    }

    public final void setRows(final int rows) {
        this.rows = rows;
    }

    public final int getColumns() {
        return columns;
    }

    public final void setColumns(final int columns) {
        this.columns = columns;
    }

    public final List<CandyColors> getColors() {
        return colors;
    }

    public final Set<CandyColors> getColorsSet() {
        final Set<CandyColors> colorSet = new HashSet<>();
        for (final CandyColors cc : this.colors) {
            colorSet.add(cc);
        }
        return colorSet;
    }

    public final void setColors(final List<CandyColors> colors) {
        this.colors = colors;
    }

    public final Map<Pair, Optional<Candy>> getGrid() {
        return grid;
    }

    public final void setGrid(final Map<Pair, Optional<Candy>> grid) {
        this.grid = grid;
    }
}
