package candy.model;

public class Level {

    /**
     * Type of level.
     * {@value MOVES} level with max number of move for reach the goal's score.
     * {@value TIME} level with a max time to reach the goal's score,
     */
    public enum Type { MOVES, TIME };

    private final Grid grid;
    private final int scoreGoal;
    private final Type type;

    public Level(final Grid grid, final int scoreGoal, final Type type) {
        this.grid = grid;
        this.scoreGoal = scoreGoal;
        this.type = type;
    }

    /**
     * @return the grid
     */
    public Grid getGrid() {
        return grid;
    }

    /**
     * @return the scoreGoal
     */
    public int getScoreGoal() {
        return scoreGoal;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    @Override
    public final String toString() {
        return "Level [grid=" + this.grid + ", scoreGoal=" + this.scoreGoal + ", type=" + this.type + "]";
    }

}
