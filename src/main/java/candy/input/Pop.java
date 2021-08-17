package candy.input;

import java.util.List;

import model.game.level.table.Table;
import other.Pair;

public interface Pop {

    void pop(List<Pair> positions, Pair switchedPosition, Table grid);
    void removeCandy(List<Pair> positions, Table grid);
}
