package model.game.level.table;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;
import other.Pair;

public interface Table {
    
    /**
     * Gives the rows of the {@link Table}.
     * @return the {@link rows} of the {@link Table}.
     */
    int getRows();
    
    /**
     * Gives the columns of the {@link Table}.
     * @return the {@link columns} of the {@link Table}.
     */
    int getColumns(); 
    
    /**
     * Gives the grid of candies of the {@link Candy}.
     * @return the gird of candies of the {@link Candy}.
     */
    Map<Pair, Optional<Candy>> getGrid();
    
    /**
     * Gives the color in the grid of candies of the {@link Candy}.
     * @return the color in the grid of candies of the {@link Candy}.
     */
    List<CandyColors> getColors(); 

}
