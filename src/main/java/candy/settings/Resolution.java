/**
 * Resolution supported for game view
 */
package candy.settings;

import java.awt.Dimension;

public enum Resolution {
    /**
     * Low quality.
     */
    LOW(new Dimension(768, 576), "768x576"),
    /**
     * High quality.
     */
    HIGH(new Dimension(1200, 900), "1200x900");

    private final Dimension dimension;
    private final String actualString;

    Resolution(final Dimension dimension, final String text) {
        this.dimension = dimension;
        this.actualString = text;
    }

    /**
     * @return the dimension
     */
    public Dimension getDimension() {
        return dimension;
    }

    /**
     * @return the actualString
     */
    public String getActualString() {
        return actualString;
    }

}
