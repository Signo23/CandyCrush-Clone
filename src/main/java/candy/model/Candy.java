/**
 * 
 */
package candy.model;

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
    private Type type;
    /**
     * Candy's color.
     */
    private Color color;


    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }
    /**
     * @param type the type to set
     */
    public void setType(final Type type) {
        this.type = type;
    }
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }
    /**
     * @param color the color to set
     */
    public void setColor(final Color color) {
        this.color = color;
    }

}
