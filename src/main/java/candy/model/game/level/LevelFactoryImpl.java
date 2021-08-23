package candy.model.game.level;

import candy.model.game.level.grid.GridBuilder;

public class LevelFactoryImpl implements LevelFactory {
    private GridBuilder builder;
    @Override
    public final Level getLevel1(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_1.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_1.getMoves(), Maps.MAP_1.getTime());
    }

    @Override
    public final Level getLevel2(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_2.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_2.getMoves(), Maps.MAP_2.getTime());
    }

    @Override
    public final Level getLevel3(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_3.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.MOVES, Maps.MAP_3.getMoves(), Maps.MAP_3.getTime());
    }

    @Override
    public final Level getLevel4(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_4.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.TIME, Maps.MAP_4.getMoves(), Maps.MAP_4.getTime());
    }

    @Override
    public final Level getLevel5(final String startingMessage, final String endingMessage, final Controller controller, 
            final Objective objective) {
        this.builder.setStartingMessage(startingMessage);
        this.builder.setEndingMessage(endingMessage);
        this.builder.setController(controller);
        this.builder.setTable(Maps.MAP_5.getCandies());
        return new LevelImpl(builder.build(), LevelTypes.TIME, Maps.MAP_5.getMoves(), Maps.MAP_5.getTime());
    }



}
