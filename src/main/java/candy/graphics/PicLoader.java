/**
 * 
 */
package candy.graphics;

import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import candy.settings.Resolution;
import candy.file.CandyReader;
import candy.model.Candy;
import candy.common.CandyPair;

public class PicLoader {

    private Image backgroung;
    private final Map<CandyPair, Image> images;
    private final Resolution resolution;

    public PicLoader(final Resolution resolution) {
        this.resolution = resolution;
        this.images = new HashMap<>();
    }

    public final void loadImage() {
        final List<CandyPair> candyType = new ArrayList<>();
        candyTypeList(candyType);
        System.out.println("Candy Type's list " + candyType);
        for (final CandyPair cp : candyType) {
            this.images.put(cp, CandyReader.getCandyImage(resolution, cp));
        }
        System.out.println("Pic loader's icons: " + this.images);
    }

    /**
     * @param candyType
     */
    private void candyTypeList(final List<CandyPair> candyType) {
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.BLUE));
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.GREEN));
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.ORANGE));
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.PURPLE));
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.RED));
        candyType.add(new CandyPair(Candy.Type.NORMAL, Candy.Color.YELLOW));
        candyType.add(new CandyPair(Candy.Type.BOMB, Candy.Color.NULL));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.BLUE));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.GREEN));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.ORANGE));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.PURPLE));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.RED));
        candyType.add(new CandyPair(Candy.Type.STRIPED, Candy.Color.YELLOW));

        this.backgroung = CandyReader.getBackground(resolution);
    }

    /**
     * @return the backgroung
     */
    public Image getBackgroung() {
        return backgroung;
    }

    public final Image getCandyImage(final CandyPair cp) {
        return this.images.get(cp);
    }

}
