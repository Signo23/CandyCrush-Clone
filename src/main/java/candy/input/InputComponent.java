package candy.input;


import candy.model.Grid;

public interface InputComponent {

    /**
     * Update the grid after check if there is a combination of candies.
     * @param ctrl
     * @param grid
     */
    void update(InputController ctrl, Grid grid);

}
