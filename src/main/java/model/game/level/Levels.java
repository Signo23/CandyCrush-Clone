package model.game.level;

import java.util.Set;
import java.util.List;
import java.util.Optional;

/**
 * The enum of all {@link Level} implemented.
 *
 */

import java.util.Map;

import model.game.level.grid.candy.Candy;
import model.game.level.table.Table;
import model.game.level.table.TableBuilder;
import other.Pair;
import model.game.level.grid.candy.CandyColors;

public enum Levels {

    /**
     * Is the first {@link Level}.
     */
	LEVEL_1(15, 20, null, Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW),
	        LevelTypes.MOVES, Optional.of(50)),
	
    /**
     * Is the second {@link Level}.
     *
     */
	LEVEL_2(20, 25, null, Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW, CandyColors.PURPLE),
            LevelTypes.MOVES, Optional.of(40)),
	
	/**
     * Is the third {@link Level}.
     *
     */
	LEVEL_3(, LevelTypes.MOVES),
	
	/**
     * Is the fourth {@link Level}.
     *
     */
	LEVEL_4(, LevelTypes.TIME),
	
	/**
     * Is the fifth {@link Level}.
     *
     */
	LEVEL_5(, LevelTypes.TIME);
	
	private TableBuilder builder;
	private Table candies;
	private LevelTypes type;
	private Optional<Integer> moves;
	//private Optional<Time> time;
	
	private Levels (int rows, int columns, Set<Pair> positions, Set<CandyColors> colors, 
	        LevelTypes type, Optional<Integer> move) {
	        //Optional<Time> time) {
		this.candies = builder.setDimensions(rows, columns)
		                        .setEmptyCells(positions)
		                        .setAvailableColor(colors)
		                        .setCandies()
		                        .build();
		this.type = type;
		this.moves = move;
		//this.time = time;
	}

}
