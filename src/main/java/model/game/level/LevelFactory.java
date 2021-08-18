package model.game.level;

public interface LevelFactory {
    /**
     * Return the first {@link Level}.
     * @param startingMessage 
     *      The starting message of the {@link Level}.
     * @param endingMessage 
     *      The ending message of the {@link Level}.
     * @param objective 
     *      The {@link Objective} of the {@link Level}.
     * @param controller 
     *      The {@link Controller} of the {@link Level}.
     * @return The {@link Level} gained.
     */
    Level getLevel1(String startingMessage, String endingMessage, Controller controller, Objective objective);
    /**
     * Return the second {@link Level}.
     * @param startingMessage 
     *      The starting message of the {@link Level}.
     * @param endingMessage 
     *      The ending message of the {@link Level}.
     * @param objective 
     *      The {@link Objective} of the {@link Level}.
     * @param controller 
     *      The {@link Controller} of the {@link Level}.
     * @return The {@link Level} gained.
     */
    Level getLevel2(String startingMessage, String endingMessage, Controller controller, Objective objective);
    /**
     * Return the third {@link Level}.
     * @param startingMessage 
     *      The starting message of the {@link Level}.
     * @param endingMessage 
     *      The ending message of the {@link Level}.
     * @param objective 
     *      The {@link Objective} of the {@link Level}.
     * @param controller 
     *      The {@link Controller} of the {@link Level}.
     * @return The {@link Level} gained.
     */
    Level getLevel3(String startingMessage, String endingMessage, Controller controller, Objective objective);
    /**
     * Return the fourth {@link Level}.
     * @param startingMessage 
     *      The starting message of the {@link Level}.
     * @param endingMessage 
     *      The ending message of the {@link Level}.
     * @param objective 
     *      The {@link Objective} of the {@link Level}.
     * @param controller 
     *      The {@link Controller} of the {@link Level}.
     * @return The {@link Level} gained.
     */
    Level getLevel4(String startingMessage, String endingMessage, Controller controller, Objective objective);
    /**
     * Return the fifth {@link Level}.
     * @param startingMessage 
     *      The starting message of the {@link Level}.
     * @param endingMessage 
     *      The ending message of the {@link Level}.
     * @param objective 
     *      The {@link Objective} of the {@link Level}.
     * @param controller 
     *      The {@link Controller} of the {@link Level}.
     * @return The {@link Level} gained.
     */
    Level getLevel5(String startingMessage, String endingMessage, Controller controller, Objective objective);
}
