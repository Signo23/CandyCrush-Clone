package candy.model.game.level.grid.table.candy;

import java.util.Optional;

import candy.graphics.GraphicsComponent;
import candy.graphics.GraphicsDraw;

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
    /**
     * Gives the {@link GraphicsComponent} of the {@link Candy}.
     * @return the {@link GraphicsComponent} of the {@link Candy}.
     */
    GraphicsComponent getGraphics();
    /**
     * Set the {@link GraphicsComponent} of the {@link Candy}.
     * @param graphics The {@link GraphicsComponent} of the {@link Candy}.
     */
    void setGraphics(GraphicsComponent graphics);
    /**
     * Update the {@link GraphicsDraw} of the {@link Candy}.
     * @param g
     */
    void updateGraphic(GraphicsDraw g);
}
