package candy.graphics;

import model.game.level.grid.candy.Candy;

public interface GraphicsComponent {

    /**
     * 
     * @param candy to update
     * @param graphic
     */
    void update(Candy candy, Graphics graphic);

}
