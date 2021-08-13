package candy.input;

import java.util.ArrayList;
import java.util.List;

import model.game.level.grid.candy.Candy;

public class CheckImpl implements Check {


    public final List<Candy> checkMatch(Candy c) {
        int incX = 0;
        int incY = -1;
        List<Candy> result = new ArrayList<>();
        result.add(c);
        result.addAll(controll(c, result, incX, incY));
        incY = 1;
        result.addAll(controll(c, result, incX, incY));
        if (result.size() < 3) {
            result.clear();
            result.add(c);
            incX = -1;
            incY = 0;
            result.addAll(controll(c, result, incX, incY));
            incY = 1;
            result.addAll(controll(c, result, incX, incY));
        }

        return result;
    }
	
	private List<Candy> controll(Candy c, List<Candy> res, int incX, int incY){
		return res;
	}
}
