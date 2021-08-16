package candy.input;

import model.game.level.table.Table;
import other.Pair;

public interface InputComponent {

    void update(Pair position, InputController c, Table grid);

}
