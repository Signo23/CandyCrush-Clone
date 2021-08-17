package model.game.level.grid;

import java.util.Optional;

import model.game.level.table.Table;

public class GridBuilderImpl implements GridBuilder {

    private Optional<Objective> objective = Optional.empty();
    private Optional<Controller> controller = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();
    private Optional<Table> table = Optional.empty();
    private boolean alreadyBuilt;
    @Override
    public final void setTable(final Table table) {
        this.table = Optional.of(table);
    }
    @Override
    public final void setController(final Controller controller) {
        this.controller = Optional.of(controller);
    }
    @Override
    public final void setObjective(final Objective objective) {
        this.objective = Optional.of(objective);
    }
    @Override
    public final void setStartingMessage(final String startMsg) {
        this.startingMessage = Optional.of(startMsg);
    }
    @Override
    public final void setEndingMessage(final String endMsg) {
        this.endingMessage = Optional.of(endMsg);
    }
    @Override
    public final Grid build() {
        if (this.alreadyBuilt) {
            throw new IllegalStateException("You can build the grid twice");
        }
        if (this.table.equals(Optional.empty())) {
            throw new IllegalArgumentException("You can build the grid if you haven't already set the table");
        }
        if (this.controller.equals(Optional.empty())) {
            throw new IllegalArgumentException("You can build the grid if you haven't already set the controller");
        } 
        if (this.objective.equals(Optional.empty())) {
            throw new IllegalArgumentException("You can build the grid if you haven't already set the objective");
        } 
        if (this.startingMessage.equals(Optional.empty())) {
            throw new IllegalArgumentException("You can build the grid if you haven't already set the starting message");
        } 
        if (this.endingMessage.equals(Optional.empty())) {
            throw new IllegalArgumentException("You can build the grid if you haven't already set the ending message");
        }
        this.alreadyBuilt = true;
        return new GridImpl(this.table, this.controller, this.objective, this.startingMessage, this.endingMessage);
        }
}
