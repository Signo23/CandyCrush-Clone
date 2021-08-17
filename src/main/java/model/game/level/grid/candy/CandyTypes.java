package model.game.level.grid.candy;
/**
 * The list of all existing {@link Candy} types.
 *
 */
public enum CandyTypes {
    /**
     * Has a standard behavior.
     */
    NORMAL(true),
    /**
     * Breaks out a horizontal line of candy when it gets broke out.
     */
    HORIZONTAL_STRIPED(true),
    /**
     * Breaks out all the candies of the same color in the grid.
     */
    BOMB(true),
    /**
     * Is a block in the table which can't be moved.
     */
    EMPTY(false);
    private boolean isMovable;
    CandyTypes(final boolean isMov) {
        this.isMovable = isMov;
    }
    public boolean isMovable() {
        return isMovable;
        }
}
