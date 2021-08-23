/**
 * 
 */
package candy.model;

import candy.model.game.level.Level;

public class GameState {

    private Level level;
    private int score;


    public GameState(/*final LevelEventListener l*/) {
        this.score = 0;
        this.level = null;
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

    public final void incScore() {
        this.score++;
    }

    public final boolean isGameOver() {
        return false;
    }
}
