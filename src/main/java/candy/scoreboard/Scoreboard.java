package candy.scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Scoreboard {
    
    private String name;
    private List<Integer> score;
    
    /**
     * @param name of Player
     */
    public Scoreboard(String name) {
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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the score
     */
    public List<Integer> getScore() {
        return score;
    }
    
    public void addScore(int levelScore) {
        this.score.add(levelScore);
    }
    
    public int getTotalScore() {
        int total = 0;
        
        for(Integer i : this.score) {
            total = total + i;
        }
        return total;
    }

    @Override
    public String toString() {
        return "Scoreboard [name=" + name + ", score=" + score + "]";
    }
}
