/**
 * 
 */
package candy.graphics;

import java.awt.Image;

import candy.settings.Resolution;
import candy.file.CandyReader;
import candy.model.Candy;

public class PicLoader {

    private Image blue, yellow, orange, red, purple, green, bomb, strBlue, strYellow, strOrange, strRed, strPurple, strGreen;
    private Image backgroung;
    private final Resolution resolution;

    public PicLoader(final Resolution resolution) {
        this.resolution = resolution;
    }

    public final void loadImage() {
        this.blue = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.BLUE);
        this.green = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.GREEN);
        this.orange = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.ORANGE);
        this.purple = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.PURPLE);
        this.red = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.RED);
        this.yellow = CandyReader.getCandyImage(resolution, Candy.Type.NORMAL, Candy.Color.YELLOW);

        this.bomb = CandyReader.getCandyImage(resolution, Candy.Type.BOMB, Candy.Color.NULL);

        this.strBlue = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.BLUE);
        this.strGreen = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.GREEN);
        this.strOrange = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.ORANGE);
        this.strPurple = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.PURPLE);
        this.strRed = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.RED);
        this.strYellow = CandyReader.getCandyImage(resolution, Candy.Type.STRIPED, Candy.Color.YELLOW);

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
