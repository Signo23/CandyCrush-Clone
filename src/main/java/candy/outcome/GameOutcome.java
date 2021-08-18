package candy.outcome;

/**
 * Contains the possible outcome of the game.
 *
 */

public enum GameOutcome {
    /**
     * It happens when the time is over but the objective of the game has not been reached.
     */
    TIME_OVER("I'm sorry, time's over!"),
    /**
     * It happens when the moves are over but the objective of the game has not been reached.
     */
    MOVES_OVER("I'm sorry, you dont have remaining moves!"),
    /**
     * Minimum score objective has been reached.
     */
    POINT_GOAL_ACHIEVED("Congrats! You have archieved the minimum threshold of points!"),
    /**
     * A further objective has been reached.
     */
    OBJECTIVE_ACHIEVED("Congrats! You have archieved the objective!");
    private String message;
    GameOutcome(final String msg) {
        this.message = msg;
    }
    public String getMessage() {
        return message;
    }
}
