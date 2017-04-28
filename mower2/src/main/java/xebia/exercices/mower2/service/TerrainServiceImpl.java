package xebia.exercices.mower2.service;

import xebia.exercices.mower2.beans.Terrain;
import xebia.exercices.mower2.beans.Tondeuse;
import xebia.exercices.mower2.constants.Commande;
import xebia.exercices.mower2.constants.Rotation;

public final class TerrainServiceImpl implements TerrainService {

	private Terrain terrain;

	/* (non-Javadoc)
	 * @see xebia.exercices.mower2.service.TerrainService#createTerrain(xebia.exercices.mower2.beans.Terrain)
	 */
	@Override
	public Terrain createTerrain(Terrain terrain) {
		assert terrain != null;
		this.terrain = terrain;
		return terrain;
	}

	/* (non-Javadoc)
	 * @see xebia.exercices.mower2.service.TerrainService#getTerrain()
	 */
	@Override
	public Terrain getTerrain() {
		return this.terrain;
	}

	/* (non-Javadoc)
	 * @see xebia.exercices.mower2.service.TerrainService#createTondeuse(xebia.exercices.mower2.beans.Tondeuse)
	 */
	@Override
	public Tondeuse createTondeuse(Tondeuse t) {
		assert t != null;
		this.terrain.add(t);
		return t;
	}

	/* (non-Javadoc)
	 * @see xebia.exercices.mower2.service.TerrainService#deplaceTondeuse(xebia.exercices.mower2.beans.Tondeuse, java.lang.Object[])
	 */
	@Override
	public void deplaceTondeuse(Tondeuse t, Object[] commandes) {
		assert t != null;
		assert commandes != null;
		for (Object c : commandes) {
			if (c instanceof Commande) {
				deplaceTondeuse(t, (Commande) c);
			} else if (c instanceof Rotation) {
				t.setOrientation(t.getOrientation().rotation((Rotation) c));
			}
		}

	}

	/* (non-Javadoc)
	 * @see xebia.exercices.mower2.service.TerrainService#deplaceTondeuse(xebia.exercices.mower2.beans.Tondeuse, xebia.exercices.mower2.constants.Commande)
	 */
	@Override
	public void deplaceTondeuse(Tondeuse t, Commande commande) {
		assert t != null;
		if (commande == Commande.AVANCE) {
			terrain.deplace(t.getPosition(), t.getPosition().add(t.getOrientation().addPosition()));
		}

	}

}
