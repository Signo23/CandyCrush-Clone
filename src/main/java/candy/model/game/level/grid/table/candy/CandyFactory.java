package candy.model.game.level.grid.table.candy;

public interface CandyFactory {
    /**
     * Return normal {@link Candy} of a certain {@link CandyColors}.
     * @param cColor The {@link CandyColors} of the {@link Candy}.
     * @return The {@link Candy} gained.
     * @throws IllegalStateException If COLOR_BOMB color have been passed as parameter.
     */
     Candy getNormalCandy(CandyColors cColor);
     /**
      * Return horizontal striped {@link Candy} of a certain {@link CandyColors}.
      * @param cColor The {@link CandyColors} of the {@link Candy}.
      * @return The {@link Candy} gained.
      * @throws IllegalStateException If COLOR_BOMB color have been passed as parameter.
      */
      Candy getHorizontalStripedCandy(CandyColors cColor);
      /**
       * Return color bomb {@link Candy}.
       * @param cColor The {@link CandyColors} of the {@link Candy}.
       * @return The {@link Candy} gained.
       * @throws IllegalStateException If a color different from COLOR_BOMB have been passed as parameter.
       */
      Candy getColorBomb(CandyColors cColor);
      /**
       * Return empty {@link Candy}.
       * @return The {@link Candy} gained.
       */
      Candy getEmpty();
}
