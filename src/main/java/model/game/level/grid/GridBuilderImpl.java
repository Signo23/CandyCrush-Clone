package model.game.level.grid;

import java.util.Map;
import java.util.Optional;

import model.game.level.grid.candy.Candy;
import model.game.level.table.TableBuilder;
import other.Pair;

public class GridBuilderImpl implements GridBuilder {

    private Optional<Objective> objective = Optional.empty();
    private Optional<Controller> controller = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();
    private Optional<TableBuilder> table = Optional.empty();
    private 
    private boolean alreadyBuilt = false;
    
    public GridBuilder setTable(TableBuilder table) {
        this.table = Optional.of(table);
        return this;
    }

	@Override
	public GridBuilder setController(Controller controller) {
		this.controller = Optional.of(controller);
		return this;
	}

	@Override
	public GridBuilder setObjective(Objective objective) {
		this.objective = Optional.of(objective);
		return this;
	}

	@Override
	public GridBuilder setStartingMessage(String startMsg) {
		this.startingMessage = Optional.of(startMsg);
		return this;
	}

	@Override
	public GridBuilder setEndingMessage(String endMsg) {
		this.endingMessage = Optional.of(endMsg);		
		return this;
	}

	@Override
	public Grid build() {
	    if (this.alreadyBuilt == true) {
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
