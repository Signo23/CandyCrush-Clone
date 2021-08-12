package model.game.level.grid.candy;

import java.util.Optional;

public interface Candy {
	
	/**
	 * Gives the {@link CandyTypes} of the {@link Candy}.
	 * @return the {@link CandyTypes} of the {@link Candy}.
	 */
	
	public Optional<CandyTypes> getCandyType();
	
	/**
	 * Set the {@link CandyColors} of the {@link Candy}.
	 * @param cType The {@link CandyColors} of the {@link Candy}.
	 */
	public void setCandyType(Optional<CandyTypes> candyType); 
	
	
	/**
	 * Gives the {@link CandyColors} of the {@link Candy}.
	 * @return the {@link CandyColors} of the {@link Candy}.
	 */
	public Optional<CandyColors> getCandyColor();
	
	
	/**
	 * Set the {@link CandyColors} of the {@link Candy}.
	 * @param cColor The {@link CandyColors} of the {@link Candy}.
	 */
	public void setCandyColor(Optional<CandyColors> candyColor);
	

}
