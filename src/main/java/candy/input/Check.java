package candy.input;

import java.util.List;

import model.game.level.table.Table;
import other.Pair;

public interface Check {

    List<Pair> checkMatch(Pair newPosition, Table grid);

}
