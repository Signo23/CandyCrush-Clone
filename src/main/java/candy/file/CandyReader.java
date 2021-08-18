/**
 * 
 */
package candy.file;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import candy.settings.Settings;
import candy.Launcher;
import candy.scoreboard.Scoreboard;

public class CandyReader {
    
    private static Gson gson;
    
    public Settings readSettings() {
        Settings set;
        try {
            final Reader reader = Files.newBufferedReader(Paths.get(Launcher.MAIN_FOLDER + Launcher.SEP + "Settings.json"));
            set = gson.fromJson(reader, Settings.class);
            reader.close();
            return set;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Scoreboard> readScoreboard() {
        List<Scoreboard> score;
        try {
            final Reader reader = Files.newBufferedReader(Paths.get(Launcher.MAIN_FOLDER + Launcher.SEP + "Scoreboard.json"));
            score = gson.fromJson(reader, new TypeToken<List<Scoreboard>>() {}.getType());
            reader.close();
            return score;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
