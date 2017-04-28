package xebia.exercices.mower2.constants;

import xebia.exercices.mower2.beans.Position;

public enum Orientation {

	NORD("N", new Position(0, 1)), EST("E", new Position(1, 0)), SUD("S", new Position(0, -1)), OUEST("O",
			new Position(-1, 0));

	private final String code;
	private final Position position;

	private Orientation(String code, Position position) {
		this.position = position;
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public Position addPosition() {
		return position;
	}

	public static Orientation findByCode(String code) {
		for (Orientation r : values()) {
			if (r.getCode().equals(code)) {
				return r;
			}
		}
		return null;
	}

	public Orientation rotation(Rotation r) {
		Orientation result = this;
		switch (r) {
		case DROITE:
			if (this.ordinal() == 3) {
				result = Orientation.values()[0];
			} else {
				result = Orientation.values()[this.ordinal() + 1];
			}

			break;

		case GAUCHE:
			if (this.ordinal() == 0) {
				result = Orientation.values()[3];
			} else {
				result = Orientation.values()[this.ordinal() - 1];
			}
		default:
		}
		return result;

	}

	@Override
	public String toString() {
		return getCode();
	}

}
