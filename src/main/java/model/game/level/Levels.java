package model.game.level;

import java.util.Set;
import java.util.Optional;

/**
 * The enumeration of all {@link Level} implemented.
 *
 */

import model.game.level.table.Table;
import model.game.level.table.TableBuilder;
import model.game.level.table.TableBuilderImpl;
import other.Pair;
import model.game.level.grid.candy.CandyColors;

public enum Levels {
    /**
     * Is the first {@link Level}.
     */
    LEVEL_1(15, 20, //dimension
            null,  //empty cells (empty candy)
            Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW), //available colors
            LevelTypes.MOVES, //level type
            Optional.of(50)), //number of moves
    /**
     * Is the second {@link Level}.
     *
     */
    LEVEL_2(20, 25, //dimension
            null, //empty cells (empty candy)
            Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW, 
                    CandyColors.PURPLE), //available colors
            LevelTypes.MOVES, //level type
            Optional.of(40)), //number of moves
    /*
     * Third table
     * X X X o o o o o X X X
     * X X o o o o o o o X X
     * X o o o o o o o o o X
     * o o o o o o o o o o o
     * o o o o o o o o o o o
     * o o o o o o o o o o o
     * X o o o o o o o o o X
     * X X o o o o o o o X X
     * X X X o o o o o X X X
     */
    /**
     * Is the third {@link Level}.
     *
     */
    LEVEL_3(10, 10, //dimension
            Set.of(new Pair(0, 0), new Pair(0, 1), new Pair(0, 2), 
                    new Pair(1, 0), new Pair(1, 1), new Pair(2, 0),
                    new Pair(0, 7), new Pair(0, 8), new Pair(0, 9), 
                    new Pair(1, 8), new Pair(1, 9), new Pair(2, 9), 
                    new Pair(7, 0), new Pair(8, 1), new Pair(8, 1), 
                    new Pair(9, 0), new Pair(9, 1), new Pair(9, 2), 
                    new Pair(7, 9), new Pair(8, 8), new Pair(8, 9), 
                    new Pair(9, 7), new Pair(9, 8), new Pair(9, 9)), //empty cells (empty candy)
            Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW, 
                    CandyColors.PURPLE), //available colors
            LevelTypes.MOVES, //level type
            Optional.of(45)), //number of moves
    /*
     * Fourth table
     * X X o o o o o o o o X X X X X
     * X X o o o o o o o o X X X X X
     * o o o o o o o o o o X X X X X
     * o o o o o o o o o o o o o o o
     * o o o o o o o o o o o o o o o
     * o o o o o o o o o o o o o o o
     * o o o o o o o o o o o o o o o
     * X X X X X o o o o o o o o o o 
     * X X X X X o o o o o o o o X X
     * X X X X X o o o o o o o o X X
     */
    /**
     * Is the fourth {@link Level}.
     *
     */
    LEVEL_4(10, 15, //dimension
            Set.of(new Pair(0, 0), new Pair(0, 1), new Pair(1, 1), new Pair(1, 0), 
                    new Pair(0, 10), new Pair(0, 11), new Pair(0, 12), new Pair(0, 13), 
                    new Pair(0, 14), new Pair(1, 10), new Pair(1, 11), new Pair(1, 12), 
                    new Pair(1, 13), new Pair(1, 14),  new Pair(2, 10), new Pair(2, 11), 
                    new Pair(2, 12), new Pair(2, 13), new Pair(2, 14), 
                    new Pair(8, 13), new Pair(8, 14), new Pair(9, 13), new Pair(9, 14), 
                    new Pair(7, 0), new Pair(7, 1), new Pair(7, 2), new Pair(7, 3), 
                    new Pair(7, 4), new Pair(8, 0), new Pair(8, 1), new Pair(8, 2), 
                    new Pair(8, 3), new Pair(8, 4), new Pair(9, 0), new Pair(9, 1), 
                    new Pair(9, 2), new Pair(9, 3), new Pair(9, 4)), //empty cells (empty candy)
            Set.of(CandyColors.ORANGE, CandyColors.RED, CandyColors.PURPLE, 
                    CandyColors.BLUE, CandyColors.GREEN), //available colors
            LevelTypes.TIME, //level type
            Optional.of(150)), //time
    /*
     * Fifth table
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     * o o o o o o o o o o o
     * o o o o o o o o o o o
     * o o o o o o o o o o o
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     * X X o o o o o o o X X
     */
    /**
     * Is the fifth {@link Level}.
     *
     */
    LEVEL_5(11, 10, //dimension
            Set.of(new Pair(0, 0), new Pair(0, 1), new Pair(1, 0), new Pair(1, 1), 
                    new Pair(2, 0), new Pair(2, 1), new Pair(3, 0), new Pair(3, 1), 
                    new Pair(0, 8), new Pair(0, 9), new Pair(1, 8), new Pair(1, 9), 
                    new Pair(2, 8), new Pair(2, 9), new Pair(3, 8), new Pair(3, 9), 
                    new Pair(7, 0), new Pair(7, 1), new Pair(8, 0), new Pair(8, 1), 
                    new Pair(9, 0), new Pair(9, 1), new Pair(10, 0), new Pair(10, 1),
                    new Pair(7, 8), new Pair(7, 9), new Pair(8, 8), new Pair(8, 9), 
                    new Pair(9, 8), new Pair(9, 9), new Pair(10, 8), new Pair(10, 9)), 
                    //empty cells (empty candy)
            Set.of(CandyColors.ORANGE, CandyColors.RED, CandyColors.PURPLE, 
                    CandyColors.BLUE, CandyColors.GREEN), //available colors
            LevelTypes.TIME, //level type
            Optional.of(150));
    private TableBuilder builder = new TableBuilderImpl();
    private Table candies;
    private LevelTypes type;
    private Optional<Integer> moves;
    //private Optional<Time> time;
    Levels(final int rows, final int columns, final Set<Pair> positions, 
            final Set<CandyColors> colors, final LevelTypes type, final Optional<Integer> move) {
        //Optional<Time> time) {
        builder.setDimensions(rows, columns);
        builder.setEmptyCells(positions);
        builder.setAvailableColor(colors);
        builder.setCandies();
        this.setCandies(builder.build());
        this.setType(type);
        this.setMoves(move);
        //this.time = time;
    }

    public Table getCandies() {
        return candies;
    }

    private void setCandies(final Table candies) {
        this.candies = candies;
    }

    public LevelTypes getType() {
        return type;
    }

    private void setType(final LevelTypes type) {
        this.type = type;
    }

    public Optional<Integer> getMoves() {
        return moves;
    }

    private void setMoves(final Optional<Integer> moves) {
        this.moves = moves;
    }

}
