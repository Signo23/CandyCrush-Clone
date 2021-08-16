package candy.input;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.table.Table;
import other.Pair;
import model.game.level.grid.candy.CandyColors;
import model.game.level.grid.candy.CandyTypes;

public class CheckImpl implements Check {

    private List<Pair> result = new ArrayList<>();
    private static final int MIN_DIM = 3;
    private static final int NEXT = 1;
    private static final int PREC = -1;
    private static final int NO_INC = 0;
    
    public List<Pair> checkMatch(Pair newPosition, Pair oldPosition, Table grid) {
        result.clear();
        if (grid.getGrid().get(newPosition).equals(CandyTypes.BOMB)) {
                bombControll(newPosition, oldPosition, grid);
                return result;
        }            
        if(grid.getGrid().get(oldPosition).equals(CandyTypes.BOMB)) {
                bombControll(oldPosition, newPosition, grid);
                return result;
        }
        
        check(newPosition, grid);
        
        if(result.size() < MIN_DIM) {
            check(oldPosition, grid);
        }
        
        if (result.size() >= MIN_DIM) {
            for (Pair elem : result) {
                if (grid.getGrid().get(elem).get().getCandyType().equals(CandyTypes.HORIZONTAL_STRIPED))){
                     double i = elem.getX();
                     int ncolumns = grid.getColumns();
                     for (int j = 0; j<ncolumns; j++) {
                         Pair pos = new Pair(i,j);
                         result.add(pos);
                     }
                }
            }
        }        
        return result;
    }
    
    private void bombControll (Pair actualPos, Pair oldPos, Table grid){
        int nrows = grid.getRows();
        int ncolumns = grid.getColumns();
        if (grid.getGrid().get(actualPos).equals(CandyTypes.BOMB)) {
            for (int i=0; i<nrows; i++) {
                for(int j=0; j<ncolumns; j++) {
                    Pair pos = new Pair(i,j);
                    if(grid.getGrid().get(pos).equals(grid.getGrid().get(oldPos))) {
                        this.result.add(pos);
                    }
                }
            }
        }
    }
	
	private void controll(Pair pos, int incX, int incY, Table grid){
	    Pair next = new Pair(pos.getX() + incX, pos.getY() + incY);
	    if (grid.getGrid().get(pos).equals(grid.getGrid().get(next))) {
	        this.result.add(next);
	        controll(next, incX, incY, grid);
	    }
	    else {
	        return;
	    }
	}

	private void check(Pair position, Table grid) {
	    int incX = NO_INC;
        int incY = PREC;
        result.add(position);
        controll(position, incX, incY, grid);
        incY = NEXT;
        controll(position, incX, incY, grid);
        if (result.size() < MIN_DIM) {
            result.clear();
            result.add(position);
            incX = PREC;
            incY = NO_INC;
            controll(position, incX, incY, grid);
            incY = NEXT;
            controll(position, incX, incY, grid);
        }
	}

}
