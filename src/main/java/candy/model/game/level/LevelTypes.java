package candy.model.game.level;
/**
 * The list of all existing {@link Level} types.
 *
 */
public enum LevelTypes {
    /**
     * Is a {@link Level} which ended if the moves are over (or if the objective have been reached).
     */
    MOVES,
    /**
     * Is a {@link Level} which ended if the time is over (or if the objective have been reached).
     * 
     */
    TIME;
}
