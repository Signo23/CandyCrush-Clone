package model.game.level.grid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.table.TableBuilder;
import other.Pair;

public class GridImpl implements Grid {
    
    private final Map<Pair, Candy> grid = new HashMap<>();
    private Objective objective;
    private Controller controller;
    private Optional<String> startingMessage;
    private Optional<String> endingMessage;
    
    public GridImpl (Map<Pair, Optional<Candy>> optionalCandyGrid, Optional<Controller> controller, Optional<Objective> objective, Optional<String> startingMessage, Optional<String> endingMessage) {
        for (int i=0; i<optionalCandyGrid.keySet().size(); i++) {
            for (int j=0; j<optionalCandyGrid.values().size(); j++) {
                Pair p = new Pair(i,j);
                this.grid.put(p, (optionalCandyGrid.get(p)).get());
            }
        }
        this.controller = controller.get();
        this.objective = objective.get();
        this.startingMessage = startingMessage;
        this.endingMessage = endingMessage;
    }

    public Objective getObjective() {
        return objective;
    }

    public Controller getController() {
        return controller;
    }

    public Optional<String> getStartingMessage() {
        return startingMessage;
    }

    public Optional<String> getEndingMessage() {
        return endingMessage;
    }

    public Map<Pair, Candy> getGrid() {
        return grid;
    }
    
    

}
