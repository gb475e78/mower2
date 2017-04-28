package xebia.exercices.mower2.parser;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.Iterator;

import xebia.exercices.mower2.beans.Terrain;
import xebia.exercices.mower2.beans.Tondeuse;
import xebia.exercices.mower2.service.TerrainService;
import xebia.exercices.mower2.service.TerrainServiceImpl;
import xebia.exercices.mower2.utils.UtilsParser;

public final class ParserFichierTondeuses {

	/**
	 * Parse le fichier et crée le terrain et les tondeuses puis effectue les
	 * deplacement.
	 * 
	 * @param stream
	 * @return
	 */
	public static final Terrain parse(InputStream stream) {
		final TerrainService service = new TerrainServiceImpl();
		String lines;
		Iterator<String> ite = new LineNumberReader(new InputStreamReader(stream)).lines().iterator();

		if (ite.hasNext()) {
			lines = ite.next();
			service.createTerrain(UtilsParser.parseTerrain(lines));
		}

		while (ite.hasNext()) {
			lines = ite.next();
			Tondeuse t1 = service.createTondeuse(UtilsParser.parseTondeuse(lines));
			if (ite.hasNext()) {
				lines = ite.next();
				service.deplaceTondeuse(t1, UtilsParser.parseCommande(lines));
			}
		}

		return service.getTerrain();

	}

}
