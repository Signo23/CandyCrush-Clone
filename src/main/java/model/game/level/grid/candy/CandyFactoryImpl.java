package model.game.level.grid.candy;

public class CandyFactoryImpl implements CandyFactory {
    @Override
    public final Candy getNormalCandy(final CandyColors cColor) {
        if (cColor == CandyColors.COLOR_BOMB) {
            throw new IllegalStateException();
        }
        return new CandyImpl(CandyTypes.NORMAL, cColor);
    }
    @Override
    public final Candy getHorizontalStripedCandy(final CandyColors cColor) {
        if (cColor == CandyColors.COLOR_BOMB) {
            throw new IllegalStateException();
        }
        return new CandyImpl(CandyTypes.HORIZONTAL_STRIPED, cColor);
    }
    @Override
    public final Candy getColorBomb(final CandyColors cColor) {
        if (cColor == CandyColors.COLOR_BOMB) {
            return new CandyImpl(CandyTypes.BOMB, cColor);
        } else {
            throw new IllegalStateException();
        }
    }
    @Override
    public final Candy getEmpty() {
        return new CandyImpl(CandyTypes.EMPTY, null);
    }
}
