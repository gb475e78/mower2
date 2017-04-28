package xebia.exercices.mower2.constants;

public enum Rotation {

	DROITE("D"), GAUCHE("G");

	private final String code;

	private Rotation(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Rotation findByCode(String code) {
		for (Rotation r : values()) {
			if (r.getCode().equals(code)) {
				return r;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return getCode();
	}
}
