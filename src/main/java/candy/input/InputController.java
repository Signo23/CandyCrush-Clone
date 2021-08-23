package candy.input;

import candy.common.Pair;

public interface InputController {

    boolean isSwitchUp();
    boolean isSwitchDown();
    boolean isSwitchLeft();
    boolean isSwitchRight();
    Pair getPosition();

}
