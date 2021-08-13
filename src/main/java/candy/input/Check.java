package candy.input;

import java.util.List;

import model.game.level.grid.candy.Candy;

public interface Check {

    /**
     * Check if the passed candy generate a combination.
     * @param c
     * @return List<Candy>
     */
     List<Candy> checkMatch(Candy c);

}
