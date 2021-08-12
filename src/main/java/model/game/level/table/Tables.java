package model.game.level.table;

/**
 * The list of all {@link Level} implemented.
 *
 */

import java.awt.geom.Point2D;
import java.util.Map;

import model.game.level.grid.candy.Candy;

public enum Tables {
	
	TABLE_1(, LevelTypes.MOVES),
	
	TABLE_2,
	
	TABLE_3,
	
	TABLE_4,
	
	TABLE_5;
	
	public Map<Point2D, Candy> candies;
	public LevelTypes type;
	
	private Tables (Map<Point2D, Candy> c, LevelTypes t) {
		this.candies = c;
		this.type = t;
	}

}
