/**
 * 
 */
package candy.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import candy.Launcher;
import candy.scoreboard.Scoreboard;
import candy.settings.Settings;

public final class CandyWriter {

    private static Gson gson;

    private CandyWriter() { }

    public static void writeSettings(final Settings set) {
        try (Writer writer = new FileWriter(Launcher.MAIN_FOLDER + Launcher.SEP + "Settings.json")) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(set, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeScoreboard(final List<Scoreboard> score) {
        try (Writer writer = new FileWriter(Launcher.MAIN_FOLDER + Launcher.SEP + "Scoreboard.json")) {
            gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(score, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
