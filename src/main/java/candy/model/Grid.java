/**
 * 
 */
package candy.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import candy.common.Position;
import candy.model.Candy.Color;

public class Grid {

    private Map<Position, Candy> candies;
    private final int row;
    private final int column;
    private List<Color> colorList;

    public Grid(final int row, final int column) {
        this.row = row;
        this.column = column;
        this.candies = new HashMap<>();
        this.colorList = new ArrayList<>();
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
     * @return the colorList
     */
    public List<Color> getColorList() {
        return colorList;
    }

    /**
     * @param colorList the colorList to set
     */
    public void setColorList(final List<Color> colorList) {
        this.colorList = colorList;
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
        return "Grid [candies=" + this.candies + ", row=" + this.row + ", columns=" + this.column + ", colorList="
                + this.colorList + "]";
    }

}
