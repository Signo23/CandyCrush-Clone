package candy;

import java.io.File;

public final class Launcher {

    /**
     * User's home directory.
     */
    public static final String HOME = System.getProperty("user.home");

    /**
     * System's file separator.
     */
    public static final String SEP = System.getProperty("file.separator");

    /**
     * Game's main folder.
     */
    public static final String MAIN_FOLDER = HOME + SEP + "OOPCandyCrush";

    private Launcher() {
    }

    public static void main(final String[] args) {
        if (new File(MAIN_FOLDER).mkdirs()) {
            System.out.println("Directory created succesfully");
        }
    }

}
