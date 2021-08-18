package model.game;

import java.util.Iterator;

import java.util.Set;

import model.game.level.Level;

public interface Game {
    /**
     * Check if there are a next {@link Level}.
     * @return true if there is a next {@link Level}, false if there isn't.
     */
    boolean hasNextLevel();
    /**
     * Set the field currentLevel to the next {@link Level} if it is possible.
     */
    void passToNextLevel();
    /**
     * Gives the current {@link Level}.
     * @return the current {@link Level}.
     */
    Level getCurrentLevel();
    /**
     * Gives the iterator of {@link Level}.
     * @return the iterator {@link Level}.
     */
    Iterator<Level> getIteratorLevel();
    /**
     * Set the iterator of {@link Level}.
     * @param levelSet the set of all {@link Level}s.
     */
    void setIteratorLevel(Set<Level> levelSet);
}
