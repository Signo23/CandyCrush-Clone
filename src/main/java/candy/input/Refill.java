package candy.input;

import candy.common.Position;
import candy.model.Candy;
import candy.model.Grid;
import candy.model.RandomCandy;

public class Refill {
    /**
     * Scroll down the candies to replace empty spaces, then generate random candies where is necessary.
     * @param grid
     */
    public final void scrollDown(final Grid grid) {

        final int nRows = grid.getRow();
        final int nColumns = grid.getColumn();
        int k;

        for (int i = nRows - 1; i > 0; i--) {
            for (int j = 0; j < nColumns; j++) {
                final Position pos = new Position(i, j);
                while (grid.getCandies().get(pos).getType().equals(Candy.Type.NULL)) {
                    for (k = i; k > 0; k--) {
                        final Position substituteCandy = new Position(k - 1, j);
                        if (grid.getCandies().get(substituteCandy).getType().equals(Candy.Type.EMPTY)) {
                            break;
                        } else {
                            grid.getCandies().put(new Position(k, j), grid.getCandies().get(substituteCandy));
                        }
                    }
                    grid.getCandies().put(new Position(k, j), RandomCandy.nextRandomCandy(grid.getColorList()));
                }
            }
        }
        for (int j = 0; j < nColumns; j++) {
            final Position pos = new Position(0, j);
            if (grid.getCandies().get(pos).getType().equals(Candy.Type.NULL)) {
                grid.getCandies().put(new Position(0, j), RandomCandy.nextRandomCandy(grid.getColorList()));
            }
        }
    }

}
