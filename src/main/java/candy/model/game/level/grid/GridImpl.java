package candy.model.game.level.grid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import candy.model.game.level.grid.table.candy.Candy;
import other.Pair;

public class GridImpl implements Grid {
    private final Map<Pair, Candy> grid = new HashMap<>();
    private Objective objective;
    private Controller controller;
    private Optional<String> startingMessage;
    private Optional<String> endingMessage;
    public GridImpl (final Map<Pair, Optional<Candy>> optionalCandyGrid, final Optional<Controller> controller, final Optional<Objective> objective, final Optional<String> startingMessage, final Optional<String> endingMessage) {
        for (int i = 0; i < optionalCandyGrid.keySet().size(); i++) {
            for (int j = 0; j < optionalCandyGrid.values().size(); j++) {
                final Pair p = new Pair(i, j);
                this.grid.put(p, optionalCandyGrid.get(p).get());
            }
        }
        this.controller = controller.get();
        this.objective = objective.get();
        this.setStartingMessage(startingMessage);
        this.setEndingMessage(endingMessage);
    }

    public final Objective getObjective() {
        return objective;
    }

    public final Controller getController() {
        return controller;
    }

    public final Optional<String> getStartingMessage() {
        return startingMessage;
    }

    public final Optional<String> getEndingMessage() {
        return endingMessage;
    }

    public final Map<Pair, Candy> getGrid() {
        return grid;
    }

    public final void setStartingMessage(final Optional<String> startingMessage) {
        this.startingMessage = startingMessage;
    }

    public final void setEndingMessage(final Optional<String> endingMessage) {
        this.endingMessage = endingMessage;
    }
}
