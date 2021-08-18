package candy.outcome;

public class GameOutcomeGUI {
    public GameOutcomeGUI (final GameOutcome gameOutcome) {
        if (gameOutcome.equals(GameOutcome.MOVES_OVER) || gameOutcome.equals(GameOutcome.TIME_OVER)) {
            //gui game failed
        } else if (gameOutcome.equals(GameOutcome.OBJECTIVE_ACHIEVED)) {
            //gui level completed
        } else if (gameOutcome.equals(GameOutcome.LEVELS_ENDED)) {
            //gui level ended
        } else {
            throw new IllegalArgumentException("The GameOutcome is wrong or don't exist!");
        }
    }

}
