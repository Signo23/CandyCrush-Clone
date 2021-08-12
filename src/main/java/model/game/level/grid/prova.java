package model.game.level.grid;

public class prova {
		private final Map<Point2D, Optional<Candy>> grid;
		private static final Random rnd = new Random();
		private final CandyFactory cndFac;
		private final Status score;
		private final List<CandyColors> spawnedCandyColors;
		private boolean updateScore;
		private final Controller controller;
		private boolean chocolateNeedUpdate = false;
		private Optional<Map<Point2D, Integer>> jelly;

		public GridManagerImpl(final Controller controller, final Map<Point2D, Optional<Candy>> initialGrid, final Status score, final List<CandyColors> colors,
				final boolean jelly) {
			if (initialGrid == null || score == null || colors == null || controller == null) {
				throw new NullPointerException();
			}
			this.controller = controller;
			this.updateScore = false;
			this.jelly = Optional.empty();
			this.grid = new HashMap<>(initialGrid);
			this.spawnedCandyColors = colors;
			this.score = score;
			rnd.setSeed(System.currentTimeMillis());
			this.cndFac = new CandyFactoryImpl();
			this.dropCandies();
			this.updateScore = true;
			if (jelly) {
				this.jelly = Optional.of(new HashMap<>());
				this.grid.forEach((crd, cnd) -> {
					this.jelly.get().put(crd, 2);
				});
			}
		}

		@Override
		public final Map<Point2D, Optional<Candy>> getGrid() {
			return new HashMap<>(this.grid);
		}

		@Override
		public final boolean move(final Point2D cndA, final Point2D cndB) {
			// Presence of coordinates.
			if ((!this.grid.containsKey(cndA)) || (!this.grid.containsKey(cndB))) {
				return false;
			}
			// Coordinates near.
			if (Math.abs(cndA.getX() - cndB.getX()) + Math.abs(cndA.getY() - cndB.getY()) != 1) {
				return false;
			}
			// Candies type (chocolate can't be moved).
			if (this.grid.get(cndA).get().getType() == CandyTypes.CHOCOLATE
					|| this.grid.get(cndB).get().getType() == CandyTypes.CHOCOLATE) {
				return false;
			}

			// Swap of candies.
			Optional<Candy> tmp = this.grid.get(cndB);
			this.grid.put(cndB, this.grid.get(cndA));
			this.grid.put(cndA, tmp);

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			boolean niceMove = this.mergeTwoCandies(cndA, cndB);
			if (niceMove) {
				this.dropCandies();
			}
			niceMove = (this.searchDestroyShapes() || niceMove);
			if (niceMove) {
				score.setJelly();
				this.score.updateMoves();
				if (this.chocolateNeedUpdate) {
					this.updateChocolate();
				}
				this.chocolateNeedUpdate = true;
				while (this.getHint() == null) {
					this.shuffle();
					this.searchDestroyShapes();
				}
				return true;
			}
			// Bad swap (no shape found) recover initial state.
			tmp = this.grid.get(cndB);
			this.grid.put(cndB, this.grid.get(cndA));
			this.grid.put(cndA, tmp);
			controller.getSound().playSound("negative_switch_sound1");

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			return false;
		}

		@Override
		public final boolean forceMove(final Point2D cndA, final Point2D cndB) {
			// Presence of coordinates.
			if ((!this.grid.containsKey(cndA)) || (!this.grid.containsKey(cndB))) {
				return false;
			}
			// Coordinates near.
			if (Math.abs(cndA.getX() - cndB.getX()) + Math.abs(cndA.getY() - cndB.getY()) != 1) {
				return false;
			}

			// Swap of candies.
			Optional<Candy> tmp = this.grid.get(cndB);
			this.grid.put(cndB, this.grid.get(cndA));
			this.grid.put(cndA, tmp);

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			this.searchDestroyShapes();
			if (this.chocolateNeedUpdate) {
				this.updateChocolate();
			}
			this.chocolateNeedUpdate = true;

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			return true;
		}

		@Override
		public final boolean mutateCandy(final Point2D cord, final Candy cnd) {
			// Presence of coordinates.
			if (!this.grid.containsKey(cord)) {
				return false;
			}
			// Chocolate can't be mutated.
			if (this.grid.get(cord).get().getType() == CandyTypes.CHOCOLATE) {
				return false;
			}

			// Mutation.
			this.grid.put(cord, Optional.of(cnd));

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			return true;
		}

		@Override
		public final boolean destroyCandy(final Point2D cord) {
			// Coordinates not contained in grid.
			if (!this.grid.containsKey(cord)) {
				return false;
			}
			// Candy already destroyed.
			if (this.grid.get(cord).isEmpty()) {
				return false;
			}

			if (this.grid.get(cord).get().getType() == CandyTypes.CHOCOLATE) {
				this.chocolateNeedUpdate = false;
			}

			// Candies to destroy.
			List<Point2D> cndDestroy = new ArrayList<>();

			// Different behavior for each candy.
			switch (this.grid.get(cord).get().getType()) {
			case STRIPED_VERTICAL:
				controller.getSound().playSound("line_blast1");
				this.grid.forEach((crd, cnd) -> {
					// Same column.
					if (crd.getY() == cord.getY()) {
						cndDestroy.add(crd);
					}
				});
				break;
			case STRIPED_HORIZONTAL:
				controller.getSound().playSound("line_blast1");
				this.grid.forEach((crd, cnd) -> {
					// Same row.
					if (crd.getX() == cord.getX()) {
						cndDestroy.add(crd);
					}
				});
				break;
			case WRAPPED:
				controller.getSound().playSound("bomb_sound1");
				this.grid.forEach((crd, cnd) -> {
					// Contour (even diagonally).
					if ((Math.abs(crd.getX() - cord.getX()) == 0 || Math.abs(crd.getX() - cord.getX()) == 1)
							&& (Math.abs(crd.getY() - cord.getY()) == 0 || Math.abs(crd.getY() - cord.getY()) == 1)) {
						cndDestroy.add(crd);
					}
				});
				break;
			case FRECKLES:
				controller.getSound().playSound("colour_bomb1");
				this.grid.forEach((crd, cnd) -> {
					// Candy not already destroyed.
					if (this.grid.get(crd).isPresent()) {
						// Same color.
						if (cnd.get().getColor() == this.grid.get(cord).get().getColor()) {
							cndDestroy.add(crd);
						}
					}
				});
				break;
			case CHOCOLATE:
				// Inform score that chocolate has been destroyed.
				this.score.update(this.grid.get(cord).get());
				this.grid.put(cord, Optional.empty());
				return true;
			default:
				break;
			}
			// Inform score that this candy has been destroyed.
			if (this.updateScore) {
				this.score.update(this.grid.get(cord).get());
			}
			// Destroy main candy.
			this.grid.put(cord, Optional.empty());

			// Update jelly on this candy.
			if (this.jelly.isPresent()) {
				this.jelly.get().put(cord, Math.max(this.jelly.get().get(cord) - 1, 0));
			}

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}

			// Destroy candies.
			for (var crd : cndDestroy) {
				this.destroyCandy(crd);
			}
			// Destroy chocolate near.
			this.destroyChocolateAround(cord);
			return true;
		}

		public final Optional<Map<Point2D, Integer>> getJelly() {
			// A simple getter of jelly.
			return this.jelly;
		}

		public final List<Point2D> getHint() {
			// Every shape in order of importance.
			for (Shapes shp : Shapes.values()) {
				var curShp = shp.getCoordinates();
				// For each shape we get every rotation.
				for (int rot = 0; rot < shp.getRotations(); rot++) {
					// For each rotation we get every near shape.
					for (var nearShp : curShp.getNearCoordinateShapes()) {
						// For each near shape we scroll all the candies in the grid.
						for (var crd : this.grid.keySet()) {
							// If candy is present.
							if (this.grid.get(crd).isPresent()) {
								// If shape can be created.
								if(this.shapePossible(curShp, crd)) {
									// If we find the shape.
									if (this.findShape(nearShp, crd, true)) {
										var tmpList = nearShp.getRelativeCoordinates();
										// We move relative coordinates based on crd.
										for (int i = 0; i < tmpList.size(); i++) {
											tmpList.set(i, new Point2D(tmpList.get(i).getX() + crd.getX(),
													tmpList.get(i).getY() + crd.getY()));
										}
										// We return this list as a tip.
										return tmpList;
									}
								}
							}
						}
					}
					curShp = curShp.getNextRotatedCandyCoordinates();
				}
			}
			return null;
		}

		public final void consumeRemainingMoves() {
			List<CandyTypes> spawnable = Arrays.asList(CandyTypes.WRAPPED, CandyTypes.STRIPED_HORIZONTAL,
					CandyTypes.STRIPED_VERTICAL);

			// For each remaining move a random special candy is generated in a random
			// position.
			// Excluding positions already occupied.
			while (this.controller.getRemainingMoves() > 0) {
				// Consume a rem. move.
				this.score.updateMoves();

				Point2D tmp;
				do {
					tmp = this.pickRandomCandy();
				} while (this.grid.get(tmp).get().getType() != CandyTypes.NORMAL);

				// Mutate the candy, same color but different type.
				this.mutateCandy(tmp, new CandyBuilderImpl().setColor(this.grid.get(tmp).get().getColor())
						.setType(spawnable.get(rnd.nextInt(spawnable.size()))).build());
			}

			// Destroying special candies until no special candies are present.
			boolean anotherFound;
			do {
				anotherFound = false;
				for (var crd : this.grid.keySet()) {
					if(this.grid.get(crd).isPresent()) {
						var cnd = this.grid.get(crd).get();
						if (cnd.getType() != CandyTypes.NORMAL && cnd.getType() != CandyTypes.CHOCOLATE) {
							// Special candy found, destroy that.
							this.destroyCandy(crd);
							anotherFound = true;
						}
					}
				}
				;
				// Make candies drop, search for shape, repeat until no special candies found.
				this.dropCandies();
			} while (anotherFound);
		}

		public final Status getCurrentScore() {
			return this.score;
		}

		private final boolean searchDestroyShapes() {
			boolean shpFound = false;
			// For each shape (ordered) we search for corresponds.
			for (Shapes shp : Shapes.values()) {
				ShapeCoordinates shpCrd = shp.getCoordinates();
				// For each shape we get every rotation.
				for (int rot = 0; rot < shp.getRotations(); rot++) {
					// For each rotation we scroll every candy in the grid.
					for (var crd : this.grid.keySet()) {
						// If candy is present.
						if (this.grid.get(crd).isPresent()) {
							CandyColors cndCol = this.grid.get(crd).get().getColor();
							// If shape is found we destroy the shape.
							if (this.findShape(shpCrd, crd, false)) {
								shpFound = true;
								// Inform score that this shape has been destroyed.
								if (this.updateScore) {
									this.score.update(shp);
								}
								// For each coordinate in shape we destroy candy.
								for (var relCrd : shpCrd.getRelativeCoordinates()) {
									// Destroying candies in shape.
									this.destroyCandy(new Point2D(crd.getX() + relCrd.getX(), crd.getY() + relCrd.getY()));
								}
								// Adding special candy if needed.
								switch (shp.getCandyType()) {
								case FRECKLES:
									this.grid.put(crd, Optional.of(cndFac.getFreckles()));
									if(this.updateScore) {
										controller.getSound().playSound("colour_bomb_created");
									}
									break;
								case STRIPED_HORIZONTAL:
									this.grid.put(crd, Optional.of(cndFac.getHorizontalStriped(cndCol)));
									if(this.updateScore) {
										controller.getSound().playSound("striped_candy_created1");
									}
									break;
								case STRIPED_VERTICAL:
									this.grid.put(crd, Optional.of(cndFac.getVerticalStripedCandy(cndCol)));
									if(this.updateScore) {
										controller.getSound().playSound("striped_candy_created1");
									}
									break;
								case WRAPPED:
									this.grid.put(crd, Optional.of(cndFac.getWrapped(cndCol)));
									if(this.updateScore) {
										controller.getSound().playSound("wrapped_candy_created1");
									}
									break;
								default:
									this.destroyCandy(crd);
									break;
								}
								this.controller.updateGrid();
							}
						}
					}
					shpCrd = shpCrd.getNextRotatedCandyCoordinates();
				}
			}
			// If at least one shape is found, we have to make candies drop.
			if (shpFound) {
				this.dropCandies();
			}
			return shpFound;
		}

		private final void dropCandies() {
			while (this.grid.containsValue(Optional.empty())) {
				this.grid.forEach((crd, cnd) -> {
					if (cnd.isEmpty()) {
						// If found a candy on top of it, bring it down, else generate a new one.
						Optional<Candy> tmp = Optional.empty();
						boolean found = false;
						for (int i = 1; i <= crd.getX(); i++) {
							if (this.grid.containsKey(new Point2D(crd.getX() - i, crd.getY()))) {
								// If candy is empty we don't need to drop that one.
								if (this.grid.get(new Point2D(crd.getX() - i, crd.getY())).isEmpty()) {
									found = true;
									break;
								}
								// Candy found.
								tmp = this.grid.get(new Point2D(crd.getX() - i, crd.getY()));
								// Here upper candy disappear.
								this.grid.put(new Point2D(crd.getX() - i, crd.getY()), Optional.empty());
								found = true;
								break;
							}
						}
						// If no candy was found, we generate a new one.
						if (!found) {
							tmp = Optional.of(cndFac
									.getNormalCandy(
											this.spawnedCandyColors.get(rnd.nextInt(this.spawnedCandyColors.size()))));
						}

						if (tmp.isPresent()) {
							//	if (!this.controller.isStageEnded()) {
							this.controller.updateGrid();
							//	}
						}

						// Candy at his new place.
						this.grid.put(crd, tmp);
					}
				});
			}
			this.searchDestroyShapes();
		}

		private final void destroyChocolateAround(final Point2D cord) {
			List<Point2D> relMov = Arrays.asList( // Up - Down - Left - Right
					new Point2D(-1, 0), new Point2D(1, 0), new Point2D(0, -1), new Point2D(0, 1));
			Point2D tmp;
			for (var rel : relMov) {
				tmp = new Point2D(cord.getX() + rel.getX(), cord.getY() + rel.getY());
				// Coordinates in grid.
				if (this.grid.containsKey(tmp)) {
					// Is not empty.
					if (this.grid.get(tmp).isPresent()) {
						// Is chocolate.
						if (this.grid.get(tmp).get().getType() == CandyTypes.CHOCOLATE) {
							this.chocolateNeedUpdate = false;
							// Inform score that chocolate has been destroyed.
							this.score.update(this.grid.get(tmp).get());
							// Destroy the chocolate.
							this.destroyCandy(tmp);
							controller.getSound().playSound("chocolate_removed");
						}
					}
				}
			}
			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}
		}

		private final boolean findShape(final ShapeCoordinates shc, final Point2D crd, final boolean near) {
			// Saving last relative coordinates checked.
			Optional<Point2D> last = Optional.empty();
			// For each relative coordinate we check if candy is the same as original one.
			for (var relCrd : shc.getRelativeCoordinates()) {
				Point2D relCord = new Point2D(crd.getX() + relCrd.getX(), crd.getY() + relCrd.getY());

				// The first one can be checked by it self.
				if (last.isEmpty()) {
					last = Optional.of(relCord);
				}

				// Coordinates in grid.
				if (!this.grid.containsKey(relCord)) {
					return false;
				}
				// Coordinates not empty.
				if (this.grid.get(relCord).isEmpty()) {
					return false;
				}
				// Not chocolate.
				if (this.grid.get(relCord).get().getType() == CandyTypes.CHOCOLATE) {
					return false;
				}
				// Not freckles.
				if (this.grid.get(relCord).get().getType() == CandyTypes.FRECKLES) {
					return false;
				}
				// Same color.
				// If shape is a near one we check for the match of colors with last relative
				// coordinates.
				// Else
				// We check for the match of colors with original one.
				if ((near) ? this.grid.get(last.get()).get().getColor() != this.grid.get(relCord).get().getColor()
						: this.grid.get(crd).get().getColor() != this.grid.get(relCord).get().getColor()) {
					return false;
				}
			}
			return true;
		}

		private final void updateChocolate() {
			List<Point2D> relMov = Arrays.asList( // Up - Down - Left - Right
					new Point2D(-1, 0), new Point2D(1, 0), new Point2D(0, -1), new Point2D(0, 1));
			// Choose a random chocolate candy.
			List<Point2D> chcList = new ArrayList<>();
			// Filling chcList with chocolate coordinates (that has no chocolate neighbor).
			for (var crd : this.grid.keySet()) {
				// Not empty.
				if (this.grid.get(crd).isPresent()) {
					// Is chocolate.
					if (this.grid.get(crd).get().getType() == CandyTypes.CHOCOLATE) {
						// Has non chocolate neighbor.
						boolean onlyChocolate = true;
						Point2D tmp;
						for (var rel : relMov) {
							tmp = new Point2D(crd.getX() + rel.getX(), crd.getY() + rel.getY());
							// Coordinates inside grid.
							if (this.grid.containsKey(tmp)) {
								// Not empty.
								if (this.grid.get(tmp).isPresent()) {
									// Is non chocolate.
									if (this.grid.get(tmp).get().getType() != CandyTypes.CHOCOLATE) {
										onlyChocolate = false;
									}
								}
							}
						}
						// If not only chocolate near.
						if (!onlyChocolate) {
							chcList.add(crd);
						}
					}
				}
			}
			if (chcList.size() == 0) {
				return;
			}
			// Select random chocolate.
			Point2D crdRandom = chcList.get(rnd.nextInt(chcList.size()));
			Point2D crdToChocolize;
			// Select random neighbor.
			do {
				int rndInd = rnd.nextInt(relMov.size());
				crdToChocolize = new Point2D(crdRandom.getX() + relMov.get(rndInd).getX(),
						crdRandom.getY() + relMov.get(rndInd).getY());
			} while ((!this.grid.containsKey(crdToChocolize)) || this.grid.get(crdToChocolize).isEmpty()
					|| this.grid.get(crdToChocolize).get().getType() == CandyTypes.CHOCOLATE);
			// Found non chocolate neighbor.
			// CHOCOLIZE IT!!!!
			this.grid.put(crdToChocolize, Optional.of(cndFac.getChocolate()));
			controller.getSound().playSound("chocolate_grows");

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}
		}

		private final void shuffle() {
			// Random number of times (200 may be enough?).
			int times = rnd.nextInt(200);
			while (times > 0) {
				// Choose 2 normal candies and swap them.
				Point2D a, b;
				do {
					a = pickRandomCandy();
				} while (this.grid.get(a).get().getType() != CandyTypes.NORMAL);
				do {
					b = pickRandomCandy();
				} while (this.grid.get(b).get().getType() != CandyTypes.NORMAL);

				times--;

				// Swap candies.
				Optional<Candy> tmp;
				tmp = this.grid.get(a);
				this.grid.put(a, this.grid.get(b));
				this.grid.put(b, tmp);
			}

			//	if (!this.controller.isStageEnded()) {
			this.controller.updateGrid();
			//	}
		}

		private final Point2D pickRandomCandy() {
			// Iterate a random number of times in the map.
			// Random pos.
			int pos = rnd.nextInt(this.grid.size());
			// Iterator.
			var it = this.grid.keySet().iterator();
			// Getting pos° candy.
			while (pos > 0) {
				it.next();
				pos--;
			}
			return it.next();
		}

		private final boolean mergeTwoCandies(final Point2D a, final Point2D b) {
			CandyTypes aT = this.grid.get(a).get().getType();
			CandyTypes bT = this.grid.get(b).get().getType();
			// In case they are the same.
			if (aT == bT || (aT == CandyTypes.STRIPED_HORIZONTAL && bT == CandyTypes.STRIPED_VERTICAL)
					|| (aT == CandyTypes.STRIPED_VERTICAL && bT == CandyTypes.STRIPED_HORIZONTAL)) {
				List<Point2D> toDestroy = new ArrayList<>();
				switch (aT) {
				case FRECKLES:
					// Just destroy every candy.
					this.grid.forEach((crd, cnd) -> {
						toDestroy.add(crd);
					});
					// Destroy all candies.
					for (var x : toDestroy) {
						this.destroyCandy(x);
					}
					return true;

				case WRAPPED:
					// Destroy candies near (24 around) (grid 5x5).
					this.grid.forEach((crd, cnd) -> {
						// If enough near.
						if (Math.abs(crd.getX() - b.getX()) <= 2 && Math.abs(crd.getY() - b.getY()) <= 2) {
							toDestroy.add(crd);
						}
					});
					// Destroy all candies in toDestroy.
					for (var x : toDestroy) {
						this.destroyCandy(x);
					}
					return true;

				case STRIPED_HORIZONTAL:
				case STRIPED_VERTICAL:
					// Destroy all candies in same row or same column.
					this.grid.forEach((crd, cnd) -> {
						// If same row or same column.
						if (crd.getX() == b.getX() || crd.getY() == b.getY()) {
							toDestroy.add(crd);
						}
					});
					// Destroy all candies.
					for (var x : toDestroy) {
						this.destroyCandy(x);
					}
					return true;

				default:
					return false;
				}
			}

			// If they are different, checks are easier with a map.
			Map<CandyTypes, Point2D> types = new HashMap<>();
			types.put(this.grid.get(a).get().getType(), a);
			types.put(this.grid.get(b).get().getType(), b);

			// No chocolate allowed.
			if (types.containsKey(CandyTypes.CHOCOLATE)) {
				return false;
			}

			// One is freckles.
			if (types.containsKey(CandyTypes.FRECKLES)) {
				// Remove freckles one.
				Point2D freckCord = types.get(CandyTypes.FRECKLES);
				types.remove(CandyTypes.FRECKLES);
				var tmp = this.grid.get(types.values().iterator().next()).get();

				List<Point2D> toDestroy = new ArrayList<>();

				// Mutate normal candies into other type candy.
				for (var cnd : this.grid.entrySet()) {
					// Same colors.
					if (cnd.getValue().get().getColor() == tmp.getColor()) {
						toDestroy.add(cnd.getKey());
						// If normal candy gets mutated.
						if (cnd.getValue().get().getType() == CandyTypes.NORMAL) {
							// Mutate candy, same color but different type.
							this.mutateCandy(cnd.getKey(), new CandyBuilderImpl().setColor(cnd.getValue().get().getColor())
									.setType(tmp.getType()).build());
						}
					}
				}
				this.grid.put(freckCord, Optional.empty());
				// Destroy all candies in toDestroy.
				for (var x : toDestroy) {
					this.destroyCandy(x);
				}
				return true;
			}

			// One is wrapped.
			if (types.containsKey(CandyTypes.WRAPPED)) {
				types.remove(CandyTypes.WRAPPED);
				Point2D tmp = types.values().iterator().next();

				List<Point2D> toDestroy = new ArrayList<>();

				// If merged with striped.
				if (this.grid.get(tmp).get().getType() == CandyTypes.STRIPED_HORIZONTAL
						|| this.grid.get(tmp).get().getType() == CandyTypes.STRIPED_VERTICAL) {
					// Destroy all candies in the same row or column (Thick of 3).
					this.grid.forEach((crd, cnd) -> {
						// If in same column or row (Thick of 3).
						if ((crd.getX() >= b.getX() - 1 && crd.getX() <= b.getX() + 1)
								|| (crd.getY() >= b.getY() - 1 && crd.getY() <= b.getY() + 1)) {
							toDestroy.add(crd);
						}
					});
					// Destroy all candies in toDestroy.
					for (var x : toDestroy) {
						this.destroyCandy(x);
					}
					return true;
				}
				return false;
			}
			return false;
		}
		
		private final boolean shapePossible(final ShapeCoordinates shp, final Point2D crd){
			Point2D relCrd;
			List<Point2D> lstCrd = shp.getRelativeCoordinates();
			// Adding implicit coordinate 0, 0.
			lstCrd.add(new Point2D(0, 0));
			for(Point2D cord : lstCrd) {
				relCrd = new Point2D(cord.getX() + crd.getX(), cord.getY() + crd.getY());
				// Not inside the grid.
				if(!this.grid.containsKey(relCrd)) {
					return false;
				}
				// Not present.
				if(this.grid.get(relCrd).isEmpty()) {
					return false;
				}
				// Is chocolate.
				if(this.grid.get(relCrd).get().getType() == CandyTypes.CHOCOLATE) {
					return false;
				}
			}
			return true;
		}
	}

}
