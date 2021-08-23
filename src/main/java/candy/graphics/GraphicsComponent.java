package candy.graphics;

import candy.model.game.level.grid.table.candy.Candy;

public interface GraphicsComponent {

    /**
     * 
     * @param candy to update
     * @param graphic
     */
    void updateCandy(Candy candy, GraphicsDraw graphic);

}
