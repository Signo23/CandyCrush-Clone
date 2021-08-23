/**
 * 
 */
package candy.model;

import candy.model.game.level.Level;

public class GameState {

    private Level level;
    private int score;


    public GameState(/*final LevelEventListener l*/) {
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    public void incScore() {
    }

    public final boolean isGameOver() {
        return false;
    }
}
