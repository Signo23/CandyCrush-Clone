package model.game.level.grid;

import java.util.Optional;

public class GridBuilderImpl implements GridBuilder {

    private Optional<Objective> objective = Optional.empty();
    private Optional<Controller> controller = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();

	@Override
	public GridBuilder setController(Controller controller) {
		this.controller = controller;
		return this;
	}

	@Override
	public GridBuilder setObjective(Objective objective) {
		this.objective = objective;
		return this;
	}

	@Override
	public GridBuilder setStartingMessage(String startMsg) {
		this.startingMessage = startMsg;
		return this;
	}

	@Override
	public GridBuilder setEndingMessage(String endMsg) {
		this.endingMessage = endMsg;		
		return this;
	}

	@Override
	public GridBuilder build() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  

}
