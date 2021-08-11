/**
 * 
 */
package candy.settings;

import java.awt.Dimension;

public final class Settings {

    private static final int DEFAULT_X_DIMENSION = 1024;
    private static final int DEFAULT_Y_DIMENSION = 1080;
    private Dimension size;
    private Boolean sound;

    public Settings() {
        this.size = new Dimension(DEFAULT_Y_DIMENSION, DEFAULT_X_DIMENSION);
        this.sound = false;
    }
    /**
     * @return the size
     */
    public Dimension getSize() {
        return size;
        }

    /**
     * @param size the size to set
     */
    public void setSize(final Dimension size) {
        this.size = size;
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
        return "Settings [size=" + size + ", sound=" + sound + "]";
        }
}
