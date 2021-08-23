package candy.common;

public class Position {

    private double x;
    private double y;

    public Position(final double x, final double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(final double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(final double y) {
        this.y = y;
    }

    @Override
    public final String toString() {
        return "Pair [x=" + x + ", y=" + y + "]";
    }

}
