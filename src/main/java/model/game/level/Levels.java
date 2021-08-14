package model.game.level;

/**
 * The list of all {@link Level} implemented.
 *
 */


import java.util.Map;

import model.game.level.grid.candy.Candy;
import other.Pair;

public enum Levels {
	
	//TABLE_1(, LevelTypes.MOVES),
	
	TABLE_2(),
	
	TABLE_3(),
	
	TABLE_4(),
	
	TABLE_5();
	
	public Map<Pair, Candy> candies;
	public LevelTypes type;
	
	private Levels (Map<Pair, Candy> c, LevelTypes t) {
		this.candies = c;
		this.type = t;
	}

}
