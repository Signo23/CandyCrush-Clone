package candy.graphics;

import model.game.level.grid.table.candy.Candy;

public interface GraphicsComponent {

    /**
     * 
     * @param candy to update
     * @param graphic
     */
    void updateCandy(Candy candy, Graphics graphic);

}
