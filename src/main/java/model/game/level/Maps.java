package model.game.level;

import java.util.Optional;
import java.util.Set;

/**
 * The enumeration of all {@link Level} implemented.
 *
 */

import model.game.level.table.Table;
import model.game.level.table.TableBuilder;
import model.game.level.table.TableBuilderImpl;
import other.Pair;
import model.game.level.grid.candy.CandyColors;

public enum Maps {
    /**
     * Is the map of first {@link Level}.
     */
    MAP_1(15, 20, //dimension
            null,  //empty cells (empty candy)
            Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW), //available colors
            Optional.of(35)), //moves
    /**
     * Is the map of second {@link Level}.
     *
     */
    MAP_2(20, 25, //dimension
            null, //empty cells (empty candy)
            Set.of(CandyColors.RED, CandyColors.ORANGE, CandyColors.YELLOW, 
                    CandyColors.PURPLE), //available colors
            Optional.of(35)), //moves
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
     * Is the map of third {@link Level}.
     *
     */
    MAP_3(10, 10, //dimension
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
            Optional.of(40)), //moves
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
     * Is the map of fourth {@link Level}.
     *
     */
    MAP_4(10, 15, //dimension
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
            Optional.empty()), //moves
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
     * Is the map of fifth {@link Level}.
     *
     */
    MAP_5(11, 10, //dimension
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
                    CandyColors.BLUE, CandyColors.GREEN), //available colors;
            Optional.empty()); //moves
    private TableBuilder builder = new TableBuilderImpl();
    private Table candies;
    private Optional<Integer> moves;
    Maps(final int rows, final int columns, final Set<Pair> positions, 
            final Set<CandyColors> colors, final Optional<Integer> moves) {
        builder.setDimensions(rows, columns);
        builder.setEmptyCells(positions);
        builder.setAvailableColor(colors);
        builder.setCandies();
        this.candies = builder.build();
        this.moves = moves;
    }

    public Table getCandies() {
        return candies;
    }

    public Optional<Integer> getMoves() {
        return moves;
    }

}
