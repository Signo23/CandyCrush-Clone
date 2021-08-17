package model.game.level;

import java.util.Optional;

import model.game.level.grid.GridBuilder;

public class LevelFactoryImpl implements LevelFactory {
    private GridBuilder builder;
    @Override
    public final Level getLevel1(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_1.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_1.getMoves());
                //final Optional<Time> time);
    }

    @Override
    public final Level getLevel2(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_2.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_2.getMoves());
                //final Optional<Time> time);
    }

    @Override
    public final Level getLevel3(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_3.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_3.getMoves());
                //final Optional<Time> time);
    }

    @Override
    public final Level getLevel4(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_4.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.TIME, Optional.empty());
                //final Optional<Time> time);
    }

    @Override
    public final Level getLevel5(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_5.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.TIME, Optional.empty());
                //final Optional<Time> time);
    }



}
