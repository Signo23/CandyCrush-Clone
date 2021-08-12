package model.game.level.grid;

public class GridBuilderImpl implements GridBuilder {
	

    private final Set<CandyColors> colors = new HashSet<>();
    private final Set<Point2D> chocolate = new HashSet<>();
    private boolean jelly = false;
    private Optional<Objective> objective = Optional.empty();
    private Optional<String> startingMessage = Optional.empty();
    private Optional<String> endingMessage = Optional.empty();
    private Optional<Controller> controller = Optional.empty();

	@Override
	public GridBuilder setController(Controller controller) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridBuilder setObjective(Objective newObjective) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridBuilder setStartingMessage(String startMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridBuilder setEndingMessage(String endMsg) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GridBuilder build() {
		// TODO Auto-generated method stub
		return null;
	}
	
	  

}
