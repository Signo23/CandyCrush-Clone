package candy.model.game;

import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import candy.model.game.level.Level;

public class GameImpl implements Game {
    private Iterator<Level> iteratorLevel;
    private Optional<Level> currentLevel;
    public GameImpl(final Set<Level> levelSet) {
        this.setIteratorLevel(levelSet);
    }
    public final boolean hasNextLevel() {
        return this.getIteratorLevel().hasNext();
    }
    public final void passToNextLevel() {
        if (this.hasNextLevel()) {
            this.currentLevel = Optional.of(this.getIteratorLevel().next());
        } else {
            this.currentLevel = Optional.empty();
        }
    }
    public final Level getCurrentLevel() {
        return currentLevel.get();
    }
    public final Iterator<Level> getIteratorLevel() {
        return iteratorLevel;
    }
    public final void setIteratorLevel(final Set<Level> levelSet) {
        this.iteratorLevel = levelSet.iterator();
    }
}
