/**
 * 
 */
package candy.model;

public class GameState {

    private final Level level;
    private int score;


    public GameState(final LevelEventListener l) {
        this.score = 0;
        this.level = LevelFactory.levelOne(l);
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
        return this.score == this.level.getScoreGoal();
    }
}
