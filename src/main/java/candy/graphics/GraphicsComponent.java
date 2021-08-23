package candy.graphics;

import candy.model.Candy;

public interface GraphicsComponent {

    /**
     * 
     * @param candy to update
     * @param graphic
     */
    void updateCandy(Candy candy, GraphicsDraw graphic);

}
