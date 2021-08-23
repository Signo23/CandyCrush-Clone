package candy.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import candy.common.Position;

public final class LevelFactory {

    private static final int LEVEL_ONE_ROWS = 9;
    private static final int LEVEL_ONE_COLUMNS = 9;

    private LevelFactory() { }

    public static Level levelOne() {
        return new Level(randomGrid(LEVEL_ONE_ROWS, LEVEL_ONE_COLUMNS), 100, Level.Type.MOVES);
    }

    private static Grid randomGrid(final int row, final int column) {
       final Grid grid = new Grid(row, column);
       final Map<Position, Candy> map = new HashMap<>();
       final Set<Candy.Color> colorSet = new HashSet<>();
       colorSet.add(Candy.Color.BLUE);
       colorSet.add(Candy.Color.GREEN);
       colorSet.add(Candy.Color.ORANGE);
       grid.setColorSet(colorSet);
        for (int i = 0; i < grid.getRow(); i++) {
            for (int j = 0; j < grid.getColumn(); j++) {
                map.put(new Position(i, j), RandomCandy.nextRandomCandy(colorSet));
            }
        }
       grid.setCandies(map);
       return grid;
    }

}
