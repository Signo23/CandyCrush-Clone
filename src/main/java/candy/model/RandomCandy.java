/**
 * 
 */
package candy.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class RandomCandy {

    private RandomCandy() { }

    public static Candy nextRandomCandy(final Set<Candy.Color> colorSet) {
        final Random rand = new Random();
        final List<Candy.Color> colors = new ArrayList<>();
        for (final Candy.Color color : colorSet) {
            colors.add(color);
        }

        return new Candy(Candy.Type.NORMAL, colors.get(rand.nextInt(colors.size())));
    }

}
