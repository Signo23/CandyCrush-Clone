/**
 * 
 */
package candy.graphics;

import java.awt.Image;

import candy.settings.Resolution;
import candy.file.CandyReader;
import model.game.level.grid.table.candy.CandyColors;
import model.game.level.grid.table.candy.CandyTypes;

public class PicLoader {

    private Image blue, yellow, orange, red, purple, green, bomb, strBlue, strYellow, strOrange, strRed, strPurple, strGreen;
    private Image backgroung;
    private final Resolution resolution;

    public PicLoader(final Resolution resolution) {
        this.resolution = resolution;
    }

    public final void loadImage() {
        this.blue = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.BLUE);
        this.green = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.GREEN);
        this.orange = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.ORANGE);
        this.purple = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.PURPLE);
        this.red = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.RED);
        this.yellow = CandyReader.getCandyImage(resolution, CandyTypes.NORMAL, CandyColors.YELLOW);

        this.bomb = CandyReader.getCandyImage(resolution, CandyTypes.BOMB, CandyColors.COLOR_BOMB);

        this.strBlue = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.BLUE);
        this.strGreen = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.GREEN);
        this.strOrange = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.ORANGE);
        this.strPurple = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.PURPLE);
        this.strRed = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.RED);
        this.strYellow = CandyReader.getCandyImage(resolution, CandyTypes.HORIZONTAL_STRIPED, CandyColors.YELLOW);

        this.backgroung = CandyReader.getBackground(resolution);
    }

    /**
     * @return the blue
     */
    public Image getBlue() {
        return blue;
    }

    /**
     * @return the yellow
     */
    public Image getYellow() {
        return yellow;
    }

    /**
     * @return the orange
     */
    public Image getOrange() {
        return orange;
    }

    /**
     * @return the red
     */
    public Image getRed() {
        return red;
    }

    /**
     * @return the purple
     */
    public Image getPurple() {
        return purple;
    }

    /**
     * @return the green
     */
    public Image getGreen() {
        return green;
    }

    /**
     * @return the bomb
     */
    public Image getBomb() {
        return bomb;
    }

    /**
     * @return the strBlue
     */
    public Image getStrBlue() {
        return strBlue;
    }

    /**
     * @return the strYellow
     */
    public Image getStrYellow() {
        return strYellow;
    }

    /**
     * @return the strOrange
     */
    public Image getStrOrange() {
        return strOrange;
    }

    /**
     * @return the strRed
     */
    public Image getStrRed() {
        return strRed;
    }

    /**
     * @return the strPurple
     */
    public Image getStrPurple() {
        return strPurple;
    }

    /**
     * @return the strGreen
     */
    public Image getStrGreen() {
        return strGreen;
    }

    /**
     * @return the backgroung
     */
    public Image getBackgroung() {
        return backgroung;
    }

}
