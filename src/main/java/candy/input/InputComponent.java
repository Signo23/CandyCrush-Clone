package candy.input;


import candy.model.game.level.grid.table.Table;

public interface InputComponent {

    /**
     * Update the grid after check if there is a combination of candies.
     * @param ctrl
     * @param grid
     */
    void update(InputController ctrl, Table grid);

}
