package candy.input;


import candy.model.Level;

public interface InputComponent {

    /**
     * Update the grid after check if there is a combination of candies.
     * @param ctrl
     * @param level
     */
    void update(InputController ctrl, Level level);

}
