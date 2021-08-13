package candy.input;

public class InputControllerImpl implements InputController {

    private boolean isSwitchUp;
    private boolean isSwitchDown;
    private boolean isSwitchLeft;
    private boolean isSwitchRight;


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

    public final void notifySwitchUp() {
        isSwitchUp = true;
    }

    public final void notifySwitchDown() {
        isSwitchDown = true;
    }

    public final void notifySwitchLeft() {
        isSwitchLeft = true;
    }

    public final void notifySwitchRight() {
        isSwitchRight = true;
    }

    public final void notifyNotSwitchUp() {
        isSwitchUp = false;
    }

    public final void noifyNotSwitchDown() {
        isSwitchDown = false;
    }

    public final void notifyNotSwitchLeft() {
        isSwitchLeft = false;
    }

    public final void notifyNotSwitchRight() {
        isSwitchRight = false;
    }
}
