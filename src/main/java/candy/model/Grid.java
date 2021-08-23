/**
 * 
 */
package candy.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import candy.model.Candy.Color;

public class Grid {

    private List<Candy> candies;
    private final int row;
    private final int columns;
    private Set<Color> colorSet;

    public Grid(final int row, final int columns) {
        this.row = row;
        this.columns = columns;
        this.candies = new ArrayList<>();
        this.colorSet = new HashSet<>();
    }

    /**
     * @return the candies
     */
    public List<Candy> getCandies() {
        return candies;
    }

    /**
     * @param candies the candies to set
     */
    public void setCandies(final List<Candy> candies) {
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
    public int getColumns() {
        return columns;
    }

    @Override
    public final String toString() {
        return "Grid [candies=" + this.candies + ", row=" + this.row + ", columns=" + this.columns + ", colorSet="
                + this.colorSet + "]";
    }

}
