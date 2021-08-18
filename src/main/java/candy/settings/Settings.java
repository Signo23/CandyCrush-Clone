/**
 * 
 */
package candy.settings;

import java.awt.Dimension;

public final class Settings {

    private Resolution resolution;
    private Boolean sound;

    public Settings() {
        this.resolution = Resolution.LOW;
        this.sound = false;
    }
    /**
     * @return the size
     */
    public Dimension getSize() {
        return resolution.getDimension();
        }

    /**
     * @param resolution the size to set
     */
    public void setResolution(final Resolution resolution) {
        this.resolution = resolution;
        }

    /**
     * @return the sound
     */
    public Boolean isSoundActive() {
        return sound;
        }

    /**
     * @param sound the sound to set
     */
    public void selectSoundStatus(final Boolean sound) {
        this.sound = sound;
        }

    @Override
    public String toString() {
        return "Settings [resolution=" + resolution + ", sound=" + sound + "]";
        }
}
