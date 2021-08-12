package model.game.level.grid.candy;

import java.util.Optional;

public class CandyFactoryImpl implements CandyFactory {

	@Override
	public Candy getNormalCandy(CandyColors cColor) {
		if (cColor == CandyColors.COLOR_BOMB) {
			throw new IllegalStateException();
		}
		return new CandyImpl(CandyTypes.NORMAL, cColor);
	}

	@Override
	public Candy getHorizontalStripedCandy(CandyColors cColor) {
		if (cColor == CandyColors.COLOR_BOMB) {
			throw new IllegalStateException();
		}
		return new CandyImpl(CandyTypes.HORIZONTAL_STRIPED, cColor);
	}

	@Override
	public Candy getVerticalStripedCandy(CandyColors cColor) {
		if (cColor == CandyColors.COLOR_BOMB) {
			throw new IllegalStateException();
		}
		return new CandyImpl(CandyTypes.VERTICAL_STRIPED, cColor);
	}

	@Override
	public Candy getColorBomb(CandyColors cColor) {
		if (cColor == CandyColors.COLOR_BOMB) {
			return new CandyImpl(CandyTypes.HORIZONTAL_STRIPED, cColor);
		}
		else {
			throw new IllegalStateException();
		}
		
	}

	@Override
	public Candy getEmpty() {
		return new CandyImpl(CandyTypes.EMPTY, Optional.empty());
	}

}
