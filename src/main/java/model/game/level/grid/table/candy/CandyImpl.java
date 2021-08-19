package model.game.level.grid.table.candy;

import java.util.Optional;

import candy.graphics.GraphicsComponent;
import candy.graphics.GraphicsDraw;

public class CandyImpl implements Candy {
    private Optional<CandyTypes> candyType;
    private Optional<CandyColors> candyColor;
    private GraphicsComponent graphics;

    public CandyImpl(final CandyTypes cType, final CandyColors cColor) {
        this.candyColor = Optional.of(cColor);
        this.candyType = Optional.of(cType);
    }
    public final Optional<CandyTypes> getCandyType() {
        return candyType;
    }
    public final void setCandyType(final Optional<CandyTypes> candyType) {
        this.candyType = candyType;
    }
    public final Optional<CandyColors> getCandyColor() {
        return candyColor;
    }
    public final void setCandyColor(final Optional<CandyColors> candyColor) {
        this.candyColor = candyColor;
    }
    public final GraphicsComponent getGraphics() {
        return graphics;
    }
    public final void setGraphics(final GraphicsComponent graphics) {
        this.graphics = graphics;
    }
    public final void updateGraphic(final GraphicsDraw g) {
        graphics.updateCandy(this, g);
    }
    @Override
    public final int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((candyColor == null) ? 0 : candyColor.hashCode());
        result = prime * result + ((candyType == null) ? 0 : candyType.hashCode());
        return result;
    }
    @Override
    public final boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CandyImpl other = (CandyImpl) obj;
        if (candyColor == null) {
            if (other.candyColor != null) {
                return false;
            }
        } else if (!candyColor.equals(other.candyColor)) {
            return false;
        }
        if (candyType == null) {
            if (other.candyType != null) {
                return false;
            }
        } else if (!candyType.equals(other.candyType)) {
            return false;
        }
        return true;
    }
    @Override
    public final String toString() {
        return "CandyImpl [candyType=" + candyType + ", candyColor=" + candyColor + "]";
    }
}
