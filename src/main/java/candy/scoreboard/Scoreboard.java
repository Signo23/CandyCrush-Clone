package candy.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {

    private String name;
    private final List<Integer> score;

    /**
     * @param name of Player
     */
    public Scoreboard(final String name) {
        this.name = name;
        this.score = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public List<Integer> getScore() {
        return score;
    }

    /**
     * @param levelScore to add to player's scores.
     */
    public void addScore(final int levelScore) {
        this.score.add(levelScore);
    }

    /**
     * @return player's total score
     */
    public int getTotalScore() {
        int total = 0;

        for (final Integer i : this.score) {
            total = total + i;
        }
        return total;
    }

    @Override
    public final String toString() {
        return "Scoreboard [name=" + name + ", score=" + score + "]";
    }
}
