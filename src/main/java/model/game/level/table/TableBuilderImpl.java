package model.game.level.table;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import other.Pair;
import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;
import model.game.level.grid.candy.CandyTypes;
import model.game.level.grid.candy.CandyFactory;
import model.game.level.grid.candy.CandyFactoryImpl;

public class TableBuilderImpl implements TableBuilder {

	private final Random rnd = new Random();
	private final CandyFactory cFactory = new CandyFactoryImpl();
	private final Map<Pair, Optional<Candy>> grid = new HashMap<>();
	private Set<CandyColors> colors = new HashSet<>();
	private int rows = 0;
	private int columns = 0;
	private boolean alreadySetEmpty = false;
	private boolean alreadyBuilt = false;

	@Override
	public TableBuilder setDimensions(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		return this;
	}

	@Override
	public TableBuilder setEmptyCells(Set<Pair> positions) {
		if (positions.isEmpty()) {
		    for (final Pair p : positions) {
		        this.grid.put(p, Optional.of(cFactory.getEmpty()));
		    }
		    this.alreadySetEmpty = true;
		} else {
		    this.alreadySetEmpty = true;
		}
		return this;
	}

	@Override
	public TableBuilder setAvailableColor(final Set<CandyColors> colors) {
		this.colors = colors;
		return this;
	}

	@Override
	public TableBuilder setCandies() {
		for (int i = 0; i < this.rows; i++) {
			for (int j = 0; j < this.columns; j++) {
				final Pair p = new Pair(i, j);
				final Optional<Candy> candy = this.grid.get(p);
				if (candy.equals(Optional.empty()) || candy.get().getCandyType() != Optional.of(CandyTypes.EMPTY)) {
						this.grid.put(p, Optional.of(this.getRandomNormalCandy(colors)));
				}
			}
		}
		return this;
	}

	@Override
	public Table build() {
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
		this.alreadyBuilt = true;
		return new TableImpl(this.grid);
		        //, this.colors, this.rows, this.columns);
	}

	@Override
	public Candy getRandomNormalCandy(final Set<CandyColors> colorSet) {
	    final List<CandyColors> colors = new LinkedList<>();
	    for (final CandyColors cc : colorSet) {
	        colors.add(cc);
	    }
		return cFactory.getNormalCandy(colors.get(rnd.nextInt(colors.size())));
	}

}
