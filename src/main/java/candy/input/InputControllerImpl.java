package candy.input;

import other.Pair;

public class InputControllerImpl implements InputController {

    private boolean isSwitchUp;
    private boolean isSwitchDown;
    private boolean isSwitchLeft;
    private boolean isSwitchRight;
    private Pair position;


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

    public final void notifySwitchUp(final Pair position) {
        isSwitchUp = true;
        isSwitchDown = false;
        isSwitchLeft = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchDown(final Pair position) {
        isSwitchDown = true;
        isSwitchUp = false;
        isSwitchLeft = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchLeft(final Pair position) {
        isSwitchLeft = true;
        isSwitchUp = false;
        isSwitchDown = false;
        isSwitchRight = false;
        this.position = position;
    }

    public final void notifySwitchRight(final Pair position) {
        isSwitchRight = true;
        isSwitchUp = false;
        isSwitchDown = false;
        isSwitchLeft = false;
        this.position = position;
    }

    public final Pair getPosition() {
        return position;
    }

}
