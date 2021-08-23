/**
 * 
 */
package candy.model;

public class Candy {

    /**
     * Type of {@link Candy}.
     */
    public enum Type { BOMB, STRIPED, NORMAL, EMPTY, NULL }

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


    public Candy(final Type type, final Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * @return the type
     */
    public Type getType() {
        return type;
    }

    /**
     * 
     * @param type
     */
    public final void setType(final Type type) {
        this.type = type;
    }

    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    public final void setColor(final Color color) {
        this.color = color;
    }

    @Override
    public final String toString() {
        return "Candy [type=" + this.type + ", color=" + this.color + "]";
    }

}
