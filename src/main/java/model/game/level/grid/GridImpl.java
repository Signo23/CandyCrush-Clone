package model.game.level.grid;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import other.Pair;

public class GridImpl implements Grid {
    
    private final Map<Pair, Candy> grid = new HashMap<>();
    
    public GridImpl (Map<Pair, Optional<Candy>> optionalCandyGrid) {
        for (int i=0; i<optionalCandyGrid.keySet().size(); i++) {
            for (int j=0; j<optionalCandyGrid.values().size(); j++) {
                Pair p = new Pair(i,j);
                this.grid.put(p, (optionalCandyGrid.get(p)).get());
            }
        }
    }

}
