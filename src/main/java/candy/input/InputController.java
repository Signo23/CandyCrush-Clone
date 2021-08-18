package candy.input;

import other.Pair;

public interface InputController {

    boolean isSwitchUp();
    boolean isSwitchDown();
    boolean isSwitchLeft();
    boolean isSwitchRight();
    Pair getPosition();

}
