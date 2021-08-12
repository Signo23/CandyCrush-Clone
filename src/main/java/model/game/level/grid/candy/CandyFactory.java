package model.game.level.grid.candy;

public interface CandyFactory {
	
	/**
	 * Return normal {@link Candy} of a certain {@link CandyColors}.
	 * @param cColor The {@link CandyColors} of the {@link Candy}.
	 * @return The {@link Candy} gained.
	 */
	Candy getNormalCandy(CandyColors cColor);
	
	/**
	 * Return horizontal striped {@link Candy} of a certain {@link CandyColors}.
	 * @param cColor The {@link CandyColors} of the {@link Candy}.
	 * @return The {@link Candy} gained.
	 */
	Candy getHorizontalStripedCandy(CandyColors cColor);

	/**
	 * Return vertical striped {@link Candy} of a certain {@link CandyColors}.
	 * @param cColor The {@link CandyColors} of the {@link Candy}.
	 * @return The {@link Candy} gained.
	 */
	Candy getVerticalStripedCandy(CandyColors cColor);

	/**
	 * Return color bomb {@link Candy}.
	 * @param cColor The {@link CandyColors} of the {@link Candy}.
	 * @return The {@link Candy} gained.
	 */
	Candy getColorBomb(CandyColors cColor);

	/**
	 * Return empty {@link Candy}.
	 * @return The {@link Candy} gained.
	 */
	Candy getEmpty();
}
