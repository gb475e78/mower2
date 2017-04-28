package xebia.exercices.mower2.service;

import xebia.exercices.mower2.beans.Terrain;
import xebia.exercices.mower2.beans.Tondeuse;
import xebia.exercices.mower2.constants.Commande;

public interface TerrainService {

	Terrain createTerrain(Terrain terrain);

	Terrain getTerrain();

	Tondeuse createTondeuse(Tondeuse t);

	void deplaceTondeuse(Tondeuse t, Object[] commandes);

	void deplaceTondeuse(Tondeuse t, Commande commande);

}