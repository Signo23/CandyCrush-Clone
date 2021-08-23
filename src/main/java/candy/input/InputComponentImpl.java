package candy.input;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import candy.common.Pair;
import candy.model.game.level.grid.table.Table;
import candy.model.game.level.grid.table.candy.Candy;



public class InputComponentImpl implements InputComponent {

    public final void update(final InputController ctrl, final Table grid) {
            final Pair position = ctrl.getPosition();
            if (ctrl.isSwitchUp()) {
                final Pair actualPosition = new Pair(position.getX() - 1, position.getY());
                switchCandies(actualPosition, position, grid);
                if (!isSwitchPossible(actualPosition, position, grid)
                    && !isSwitchPossible(position, actualPosition, grid)) {
                    switchCandies(actualPosition, position, grid);
                }
            } else if (ctrl.isSwitchDown()) {
                final Pair actualPosition = new Pair(position.getX() + 1, position.getY());
                switchCandies(actualPosition, position, grid);
                if (!isSwitchPossible(actualPosition, position, grid)
                    && !isSwitchPossible(position, actualPosition, grid)) {
                    switchCandies(actualPosition, position, grid);
                }
            } else if (ctrl.isSwitchLeft()) {
                final Pair actualPosition = new Pair(position.getX(), position.getY() - 1);
                switchCandies(actualPosition, position, grid);
                if (!isSwitchPossible(actualPosition, position, grid)
                    && !isSwitchPossible(position, actualPosition, grid)) {
                    switchCandies(actualPosition, position, grid);
                }
            } else if (ctrl.isSwitchRight()) {
                final Pair actualPosition = new Pair(position.getX(), position.getY() + 1);
                switchCandies(actualPosition, position, grid);
                if (!isSwitchPossible(actualPosition, position, grid)
                    && !isSwitchPossible(position, actualPosition, grid)) {
                    switchCandies(actualPosition, position, grid);
                }
            }
    }

    /**
     * Control if the switch generate a combination of candies.
     * @param newPos
     * @param oldPos
     * @param grid
     * @return
     */
    private boolean isSwitchPossible(final Pair newPos, final Pair oldPos, final Table grid) {
        final CompleteCheck check = new CompleteCheck();
        final Pop pop = new PopImpl();
        final Refill refill = new Refill();
        final List<Pair> result = check.completeCheck(newPos, oldPos, grid);
        if (!result.isEmpty()) {
            pop.pop(result, newPos, grid);
            refill.scrollDown(grid);
            return true;
        }
        return false;
    }

    /**
     * Switch the candies in newPos and oldPos.
     * @param newPos
     * @param oldPos
     * @param table
     */
    private void switchCandies(final Pair newPos, final Pair oldPos, final Table table) {
        final Map<Pair, Optional<Candy>> grid = table.getGrid();
        final Optional<Candy> temp = grid.get(oldPos);
        grid.put(oldPos, grid.get(newPos));
        grid.put(newPos, temp);
    }

}
