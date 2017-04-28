package xebia.exercices.mower2.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representant le terrain
 * 
 * @author user
 *
 */
public final class Terrain {

	private final Tondeuse[][] cartes;
	private final int sizex;
	private final int sizey;
	private final List<Tondeuse> tondeuses = new ArrayList<>();

	public Terrain(int sizex, int sizey) {
		this.sizex = sizex;
		this.sizey = sizey;
		cartes = new Tondeuse[sizex][sizey];
	}

	public Tondeuse getTondeuse(Position p) {
		if (valide(p)) {
			return cartes[p.getY()][p.getX()];
		} else {
			return null;
		}
	}

	public boolean isTondeuse(Position p) {
		return getTondeuse(p) != null;
	}

	public void add(Tondeuse t) {
		Position p = t.getPosition();
		add(p, t);
	}

	private void add(Position p, Tondeuse t) {
		if (valide(p) && !tondeuses.contains(t)) {
			if (!isTondeuse(p)) {
				cartes[p.getY()][p.getX()] = t;
				tondeuses.add(t);
				t.setPosition(p);

			}
		}
	}

	public void deplace(Position depart, Position arrive) {
		if (valide(depart) && valide(arrive)) {
			if (isTondeuse(depart) && !isTondeuse(arrive)) {
				final Tondeuse t = cartes[depart.getY()][depart.getX()];
				cartes[arrive.getY()][arrive.getX()] = t;
				cartes[depart.getY()][depart.getX()] = null;
				t.setPosition(arrive);
			}
		}

	}

	public int getSizex() {
		return sizex;
	}

	public int getSizey() {
		return sizey;
	}

	public boolean valide(Position position) {
		if (sizex <= position.getX() || position.getX() < 0) {
			return false;
		}
		if (sizey <= position.getY() || position.getY() < 0) {
			return false;
		}
		return true;
	}

	public List<Tondeuse> getTondeuses() {
		return tondeuses;
	}

}
