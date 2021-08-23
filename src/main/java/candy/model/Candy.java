/**
 * 
 */
package candy.model;

import candy.common.Position;

public class Candy {

    /**
     * Type of {@link Candy}.
     */
    public enum Type { BOMB, SRIPED, NORMAL, EMPTY }

    /**
     * Color of {@link Candy}.
     */
    public enum Color { BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW, NULL }


    /**
     * Candy's type.
     */
    private final Type type;
    /**
     * Candy's color.
     */
    private final Color color;
    /**
     * Candy's position {@link Position}.
     */
    private Position position;

    public Candy(final Type type, final Color color, final Position position) {
        this.type = type;
        this.color = color;
        this.position = position;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @return the position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(final Position position) {
        this.position = position;
    }

}
