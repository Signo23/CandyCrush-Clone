/**
 * 
 */
package candy.settings;

public final class SettingsController {

    public void setUpSettings() {
        final Settings set = new Settings();
        new SettingsGUI(set);
        }
}
