package model.game.level;

import java.util.Optional;

import model.game.level.grid.Grid;

public class LevelImpl implements Level {
    private final Grid grid;
    private final LevelTypes type;
    private final Optional<Integer> moves;
    //private Time time; 
    public LevelImpl(final Grid grid, final LevelTypes type, final Optional<Integer> moves
            //final Optional<Time> time);
            ) {
        this.grid = grid;
        this.type = type;
        this.moves = moves;
        //this.time = time;
    }
    public final Grid getGrid() {
        return grid;
    }
    public final LevelTypes getType() {
        return type;
    }
    public final Optional<Integer> getMoves() {
        return moves;
    }
}