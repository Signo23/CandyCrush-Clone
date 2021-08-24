package candy.model;

import candy.input.InputComponent;
import candy.input.InputController;

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
    private final InputComponent input;
    private final LevelEventListener listener;

    public Level(final Grid grid, final int scoreGoal, final Type type, final InputComponent input, final LevelEventListener listener) {
        this.grid = grid;
        this.scoreGoal = scoreGoal;
        this.type = type;
        this.input = input;
        this.listener = listener;
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

    public final void updateInput(final InputController controller) {
        this.input.update(controller, this);
    }

    public final void notifyLevelEvent(final LevelEvent ev) {
        this.listener.notifyEvent(ev);
    }

    @Override
    public final String toString() {
        return "Level [grid=" + this.grid + ", scoreGoal=" + this.scoreGoal + ", type=" + this.type + "]";
    }

}
