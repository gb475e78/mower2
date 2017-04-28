package xebia.exercices.mower2.beans;

import java.io.Serializable;

/**
 * Class representant les coordonnées x,y d'une tondeuse
 * 
 * @author user
 *
 */
public final class Position implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int x;
	private final int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Position add(Position p) {
		return new Position(x + p.x, y + p.y);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Position) {
			final Position p = (Position) obj;
			return this.x == p.x && this.y == p.y;
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + x + " " + y + ")";
	}

}
