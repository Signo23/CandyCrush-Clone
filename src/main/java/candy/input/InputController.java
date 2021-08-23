package candy.input;

import candy.common.Position;

public interface InputController {

    boolean isSwitchUp();
    boolean isSwitchDown();
    boolean isSwitchLeft();
    boolean isSwitchRight();
    Position getPosition();

}
