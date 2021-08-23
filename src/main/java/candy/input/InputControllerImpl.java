package candy.input;

import candy.common.Position;

public class InputControllerImpl implements InputController {

    private boolean isSwitchUp;
    private boolean isSwitchDown;
    private boolean isSwitchLeft;
    private boolean isSwitchRight;
    private Position position;


    public final boolean isSwitchUp() {
        return isSwitchUp;
    }

    public final boolean isSwitchDown() {
        return isSwitchDown;
    }

    public final boolean isSwitchLeft() {
        return isSwitchLeft;
    }

    public final boolean isSwitchRight() {
        return isSwitchRight;
    }

    public final void notifySwitchUp(final Position position) {
        isSwitchUp = true;
        isSwitchDown = false;
        isSwitchLeft = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchDown(final Position position) {
        isSwitchDown = true;
        isSwitchUp = false;
        isSwitchLeft = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchLeft(final Position position) {
        isSwitchLeft = true;
        isSwitchUp = false;
        isSwitchDown = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchRight(final Position position) {
        isSwitchRight = true;
        isSwitchUp = false;
        isSwitchDown = false;
        isSwitchLeft = false;
        this.position = position;
    }

    public final Position getPosition() {
        return position;
    }

}
