package model.game.level.grid;

import java.util.Optional;

import model.game.level.table.TableBuilder;

public class GridBuilderImpl implements GridBuilder {

    private Optional<Objective> objective = Optional.empty();
    private Optional<Controller> controller = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();
    private Optional<TableBuilder> tableBuilder = Optional.empty();
    
    public GridBuilderImpl (TableBuilder table) {
        this.tableBuilder = Optional.of(table);
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
	public GridBuilder build() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  

}
