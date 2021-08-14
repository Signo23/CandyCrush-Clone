package model.game.level.table;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.grid.candy.CandyColors;
import other.Pair;
public class TableImpl implements Table {
    
    private Map<Pair, Optional<Candy>> grid = new HashMap<>();
    //private List<CandyColors> colors = new LinkedList<>();
    //private int rows = 0;
    //private int columns = 0;
    
    public TableImpl (Map<Pair, Optional<Candy>> g) {
            //List<CandyColors> col, int row, int column) {
        this.grid = g;
        //this.colors = col;
        //this.rows = row;
        //this.columns = column;
    }

    //public int getRows() {
        //return rows;
    //}

    //public int getColumns() {
        //return columns;
    //}

    //public List<CandyColors> getColors() {
        //return colors;
    //}
    
    public Map<Pair, Optional<Candy>> getGrid() {
        return grid;
    }

}
