package candy.model.game.level.grid;

import java.util.List;
import java.util.Optional;

import candy.input.Check;
import candy.input.Pop;
import candy.input.PopImpl;
import candy.input.Refill;
import candy.input.SimpleCheck;
import candy.model.game.level.grid.table.Table;
import other.Pair;

public class GridBuilderImpl implements GridBuilder {

    private Optional<Objective> objective = Optional.empty();
    private Optional<Controller> controller = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();
    private Optional<Table> table = Optional.empty();
    private boolean alreadyChecked;
    private boolean alreadyBuilt;
    @Override
    public final void setTable(final Table table) {
        this.table = Optional.of(table);
        this.checkTable();
    }
    public final void checkTable() {
        boolean moves;
        final Check check = new SimpleCheck();
        final Pop pop = new PopImpl();
        final Refill refill = new Refill();
        alreadyChecked = false;
        while (moves) {
            moves = false;
            for (int i = 0; i < this.table.get().getRows(); i++) {
                for (int j = 0; j < this.table.get().getColumns(); j++) {
                    final Pair p = new Pair(i, j);
                    final List<Pair> result;
                    result = check.checkMatch(p, this.table.get());
                    if (!result.isEmpty()) {
                        pop.removeCandy(result, this.table.get());
                        refill.scrollDown(this.table.get());
                        moves = true;
                        i = this.table.get().getRows();
                        j = this.table.get().getColumns();
                        alreadyChecked = false;
                    }
                }
            }
        }
        alreadyChecked = true;
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
        if (!this.alreadyChecked) {
            throw new IllegalStateException("You can build the grid if you haven't checked the table");
        }
        this.alreadyBuilt = true;
        return new GridImpl(this.table, this.controller, this.objective, this.startingMessage, this.endingMessage);
        }
}
