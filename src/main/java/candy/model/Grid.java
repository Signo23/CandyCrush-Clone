/**
 * 
 */
package candy.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import candy.common.Position;
import candy.model.Candy.Color;

public class Grid {

    private Map<Position, Candy> candies;
    private final int row;
    private final int column;
    private Set<Color> colorSet;

    public Grid(final int row, final int column) {
        this.row = row;
        this.column = column;
        this.candies = new HashMap<>();
        this.colorSet = new HashSet<>();
    }

    /**
     * @return the candies
     */
    public Map<Position, Candy> getCandies() {
        return this.candies;
    }

    /**
     * @param candies the candies to set
     */
    public void setCandies(final Map<Position, Candy> candies) {
        this.candies = candies;
    }

    /**
     * @return the colorSet
     */
    public Set<Color> getColorSet() {
        return colorSet;
    }

    /**
     * @param colorSet the colorSet to set
     */
    public void setColorSet(final Set<Color> colorSet) {
        this.colorSet = colorSet;
    }

    /**
     * @return the row
     */
    public int getRow() {
        return row;
    }

    /**
     * @return the columns
     */
    public int getColumn() {
        return column;
    }

    @Override
    public final String toString() {
        return "Grid [candies=" + this.candies + ", row=" + this.row + ", columns=" + this.column + ", colorSet="
                + this.colorSet + "]";
    }

}
