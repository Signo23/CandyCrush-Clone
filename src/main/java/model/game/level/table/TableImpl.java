package model.game.level.table;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;
import other.Pair;

public class TableImpl implements Table {
    private Map<Pair, Optional<Candy>> grid = new HashMap<>();
    private List<CandyColors> colors;
    private int rows;
    private int columns;
    public TableImpl(final Map<Pair, Optional<Candy>> g, final Set<CandyColors> colorSet, final int row, final int column) {
        this.grid = g;
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
    public final void setColors(final List<CandyColors> colors) {
        this.colors = colors;
    }
    public final Map<Pair, Optional<Candy>> getGrid() {
        return grid;
    }
}
