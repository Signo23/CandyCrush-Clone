/**
 * 
 */
package candy.file;

import java.awt.Image;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import candy.settings.Resolution;
import candy.settings.Settings;
import candy.Launcher;
import candy.scoreboard.Scoreboard;
import candy.common.CandyPair;

public final class CandyReader {

    private static Gson gson;

    private CandyReader() { }

    public static Settings readSettings() {
        try (Reader reader = Files.newBufferedReader(Paths.get(Launcher.MAIN_FOLDER + Launcher.SEP + "Settings.json"))) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            final Settings set = gson.fromJson(reader, Settings.class);
            reader.close();
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Settings();
    }

    public static List<Scoreboard> readScoreboard() {
        List<Scoreboard> score;
        try (Reader reader = Files.newBufferedReader(Paths.get(Launcher.MAIN_FOLDER + Launcher.SEP + "Scoreboard.json"))) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            score = gson.fromJson(reader, new TypeToken<List<Scoreboard>>() { }.getType());
            reader.close();
            return score;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<Scoreboard>();
    }

    public static Image getCandyImage(final Resolution res, final CandyPair candy) {
        System.out.println("Loaded icon in" + res.getActualString() + Launcher.SEP + candy.getType().name() + "_" + candy.getColor().name() + ".png");
        return loadImage(res.getActualString() + Launcher.SEP + candy.getType().name() + "_" + candy.getColor().name() + ".png");
    }

    public static Image getBackground(final Resolution res) {
        return loadImage(res.getActualString() + Launcher.SEP + "background.png");
    }

    private static Image loadImage(final String path) {
        try {
            System.out.println("Loaded image in" + path);
            return ImageIO.read(ClassLoader.getSystemResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
