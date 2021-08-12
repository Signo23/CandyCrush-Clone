package model.game.level.grid.candy;

import java.util.Optional;

public class CandyImpl implements Candy {
	
	private Optional<CandyTypes> candyType = Optional.empty();
	private Optional<CandyColors> candyColor = Optional.empty();
	
	public CandyImpl (CandyTypes cType, CandyColors cColor) {
		this.candyColor = Optional.of(cColor);
		this.candyType = Optional.of(cType);
	}
	
	public Optional<CandyTypes> getCandyType() {
		return candyType;
	}
	
	public void setCandyType(Optional<CandyTypes> candyType) {
		this.candyType = candyType;
	}
	
	public Optional<CandyColors> getCandyColor() {
		return candyColor;
	}
	
	public void setCandyColor(Optional<CandyColors> candyColor) {
		this.candyColor = candyColor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candyColor == null) ? 0 : candyColor.hashCode());
		result = prime * result + ((candyType == null) ? 0 : candyType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandyImpl other = (CandyImpl) obj;
		if (candyColor == null) {
			if (other.candyColor != null)
				return false;
		} else if (!candyColor.equals(other.candyColor))
			return false;
		if (candyType == null) {
			if (other.candyType != null)
				return false;
		} else if (!candyType.equals(other.candyType))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "CandyImpl [candyType=" + candyType + ", candyColor=" + candyColor + "]";
	}

	
}
