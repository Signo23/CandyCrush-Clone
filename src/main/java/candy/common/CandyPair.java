package candy.common;

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
    public final String toString() {
        return "CandyPair [type=" + type + ", color=" + color + "]";
    }



}
