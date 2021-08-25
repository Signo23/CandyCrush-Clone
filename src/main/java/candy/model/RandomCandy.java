/**
 * 
 */
package candy.model;

import java.util.List;
import java.util.Random;

import candy.graphics.CandyComponent;

public final class RandomCandy {

    private RandomCandy() { }

    public static Candy nextRandomCandy(final List<Candy.Color> colorList) {
        final Random rand = new Random();
        return new Candy(Candy.Type.NORMAL, colorList.get(rand.nextInt(colorList.size())), new CandyComponent());
    }

}
