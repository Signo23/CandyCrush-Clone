package model.game.level.grid.table;

import java.util.HashMap;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

/*import candy.input.Check;
import candy.input.SimpleCheck;
import candy.input.Pop;
import candy.input.PopImpl;
import candy.input.Refill;*/
import other.Pair;
import model.game.level.grid.table.candy.Candy;
import model.game.level.grid.table.candy.CandyColors;
import model.game.level.grid.table.candy.CandyTypes;
import model.game.level.grid.table.candy.CandyFactory;
import model.game.level.grid.table.candy.CandyFactoryImpl;

public class TableBuilderImpl implements TableBuilder {
    private final CandyFactory cFactory = new CandyFactoryImpl();
    private final Map<Pair, Optional<Candy>> grid = new HashMap<>();
    private Set<CandyColors> colors = new HashSet<>();
    private int rows;
    private int columns;
    private boolean alreadySetEmpty;
    //private boolean alreadyChecked;
    private boolean alreadyBuilt;
    @Override
    public final void setDimensions(final int rows, final int columns) {
        this.rows = rows;
        this.columns = columns;
    }
    @Override
    public final void setEmptyCells(final Set<Pair> positions) {
        if (positions.isEmpty()) {
            for (final Pair p : positions) {
                this.grid.put(p, Optional.of(cFactory.getEmpty()));
            }
            this.alreadySetEmpty = true;
        } else {
            this.alreadySetEmpty = true;
        }
    }
    @Override
    public final void setAvailableColor(final Set<CandyColors> colors) {
        this.colors = colors;
    }
    @Override
    public final void setCandies() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                final Pair p = new Pair(i, j);
                final Optional<Candy> candy = this.grid.get(p);
                if (candy.equals(Optional.empty()) || candy.get().getCandyType() != Optional.of(CandyTypes.EMPTY)) {
                    this.grid.put(p, Optional.of(this.getRandomNormalCandy(colors)));
                }
            }
        }
    }
    /*@Override
    public final void checkTable() {
        boolean moves;
        final Check check = new SimpleCheck();
        final Pop pop = new PopImpl();
        final Refill refill = new Refill();
        while (moves) {
            moves = false;
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    final Pair p = new Pair(i, j);
                    final List<Pair> result;
                    result = check.checkMatch(p, this.grid);
                    if (!result.isEmpty()) {
                        pop.removeCandy(result, this.grid);
                        refill.scrollDown(this.grid);
                        moves = true;
                        i = this.rows;
                        j = this.columns;
                        alreadyChecked = false;
                    }
                }
            }
        }
        alreadyChecked = true;
    }*/
    @Override
    public final Table build() {
        if (this.alreadyBuilt) {
            throw new IllegalStateException("You can build the table twice");
            }
        if (this.rows < 0 || this.columns < 0) {
            throw new IllegalArgumentException("You can build the table if you haven't already set dimensions");
        } 
        if (!this.alreadySetEmpty) {
            throw new IllegalArgumentException("You can build the table if you haven't already set empty spaces");
        } 
        if (this.colors.isEmpty()) {
            throw new IllegalArgumentException("You can build the table if you haven't already choose the color of the candies");
        } 
        if (this.grid.size() != this.rows * this.columns) {
            throw new IllegalArgumentException("You can build the table if you haven't fill the grid");
        }
        /*if (!this.alreadyChecked) {
            throw new IllegalStateException("You can build the table if you haven't checked it");
        }*/
        this.alreadyBuilt = true;
        return new TableImpl(this.grid, this.colors, this.rows, this.columns);
    }
    @Override
    public final Candy getRandomNormalCandy(final Set<CandyColors> colorSet) {
        final Random rnd = new Random();
        final List<CandyColors> colors = new LinkedList<>();
        for (final CandyColors cc : colorSet) {
            colors.add(cc);
        }
        return cFactory.getNormalCandy(colors.get(rnd.nextInt(colors.size())));
        }
}
