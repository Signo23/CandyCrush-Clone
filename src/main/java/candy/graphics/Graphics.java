package candy.graphics;

import java.util.Map;

import candy.common.Position;
import model.game.level.grid.candy.Candy;

public interface Graphics {
    
    void drawGrid(Map<Position, Candy> grid);

}
