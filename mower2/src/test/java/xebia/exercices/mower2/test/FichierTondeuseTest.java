package xebia.exercices.mower2.test;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import xebia.exercices.mower2.beans.Terrain;
import xebia.exercices.mower2.constants.Orientation;
import xebia.exercices.mower2.parser.ParserFichierTondeuses;

public class FichierTondeuseTest {

	public static final String FILE_PATH_TEST = "/TestTondeuses.txt";
	
	@Test
	public void testFichierTondeuses() {
		InputStream stream = this.getClass().getResourceAsStream(FILE_PATH_TEST);
		
		//Lancement du test
		Terrain t = ParserFichierTondeuses.parse(stream);
		
		//Verification
		Assert.assertNotNull("Le fichier n'a pas pu être parsé",t);
		Assert.assertEquals("Le parser n'a pas retourner le bon nombre de tondeuse",2, t.getTondeuses().size());
		
		//Premiere tondeuse 1 3 N
		Assert.assertEquals(1, t.getTondeuses().get(0).getPosition().getX());
		Assert.assertEquals(3, t.getTondeuses().get(0).getPosition().getY());
		Assert.assertEquals(Orientation.NORD, t.getTondeuses().get(0).getOrientation());


		//Deuxieme tondeuse 5 1 E
		Assert.assertEquals(5, t.getTondeuses().get(1).getPosition().getX());
		Assert.assertEquals(1, t.getTondeuses().get(1).getPosition().getY());
		Assert.assertEquals(Orientation.EST, t.getTondeuses().get(1).getOrientation());

		
	}

}
