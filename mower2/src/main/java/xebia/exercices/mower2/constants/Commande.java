package xebia.exercices.mower2.constants;

public enum Commande {

	AVANCE("A");

	private final String code;

	private Commande(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public static Commande findByCode(String code) {
		for (Commande r : values()) {
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
