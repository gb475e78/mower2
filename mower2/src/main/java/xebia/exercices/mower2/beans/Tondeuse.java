package xebia.exercices.mower2.beans;

import xebia.exercices.mower2.constants.Orientation;

public final class Tondeuse {

	private Orientation orientation;
	private Position position;
	private final String name;

	public Tondeuse(String name) {
		assert name != null;
		this.name = name;
	}

	public Tondeuse(String name, Orientation o, Position p) {
		this(name);
		this.setOrientation(o);
		this.setPosition(p);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		this.orientation = orientation;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Tondeuse) {
			this.name.equals(((Tondeuse) obj).name);
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.position != null && this.orientation != null) {
			return this.position.toString() + this.orientation.getCode();
		} else {
			return super.toString();
		}
	}

}
