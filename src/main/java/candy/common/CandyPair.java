package candy.common;

import java.util.Objects;

import candy.model.Candy;

public class CandyPair {

    private Candy.Type type;
    private Candy.Color color;

    public CandyPair(final Candy.Type type, final Candy.Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * @return the type
     */
    public Candy.Type getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final Candy.Type type) {
        this.type = type;
    }

    /**
     * @return the color
     */
    public Candy.Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(final Candy.Color color) {
        this.color = color;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(color, type);
    }

    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CandyPair)) {
            return false;
        }
        final CandyPair other = (CandyPair) obj;
        return color == other.color && type == other.type;
    }

    @Override
    public final String toString() {
        return "CandyPair [type=" + type + ", color=" + color + "]";
    }



}
