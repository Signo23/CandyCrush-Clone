package model.game.level.grid.candy;

import java.util.Optional;

public interface Candy {
    /**
     * Gives the {@link CandyTypes} of the {@link Candy}.
     * @return the {@link CandyTypes} of the {@link Candy}.
     */
    Optional<CandyTypes> getCandyType();
    /**
     * Set the {@link CandyColors} of the {@link Candy}.
     * @param cType The {@link CandyColors} of the {@link Candy}.
     */
    void setCandyType(Optional<CandyTypes> cType); 
    /**
     * Gives the {@link CandyColors} of the {@link Candy}.
     * @return the {@link CandyColors} of the {@link Candy}.
     */
    Optional<CandyColors> getCandyColor();
    /**
     * Set the {@link CandyColors} of the {@link Candy}.
     * @param cColor The {@link CandyColors} of the {@link Candy}.
     */
    void setCandyColor(Optional<CandyColors> cColor);
}
