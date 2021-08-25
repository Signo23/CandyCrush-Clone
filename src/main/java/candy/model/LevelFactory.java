package candy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import candy.common.Position;
import candy.input.InputComponentImpl;

public final class LevelFactory {

    private static final int LEVEL_ONE_ROWS = 9;
    private static final int LEVEL_ONE_COLUMNS = 9;

    private LevelFactory() { }

    public static Level levelOne(final LevelEventListener listener) {
        return new Level(randomGrid(LEVEL_ONE_ROWS, LEVEL_ONE_COLUMNS), 100, Level.Type.MOVES, new InputComponentImpl(), listener);
    }

    private static Grid randomGrid(final int row, final int column) {
       final Grid grid = new Grid(row, column);
       final Map<Position, Candy> map = new HashMap<>();
       final List<Candy.Color> colorList = new ArrayList<>();
       colorList.add(Candy.Color.BLUE);
       colorList.add(Candy.Color.GREEN);
       colorList.add(Candy.Color.ORANGE);
       grid.setColorList(colorList);
        for (int i = 0; i < grid.getRow(); i++) {
            for (int j = 0; j < grid.getColumn(); j++) {
                map.put(new Position(i, j), RandomCandy.nextRandomCandy(colorList));
            }
        }
       grid.setCandies(map);
       System.out.println(map);
       return grid;
    }

}
