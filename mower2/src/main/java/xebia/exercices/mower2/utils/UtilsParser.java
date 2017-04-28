package xebia.exercices.mower2.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import xebia.exercices.mower2.beans.Position;
import xebia.exercices.mower2.beans.Terrain;
import xebia.exercices.mower2.beans.Tondeuse;
import xebia.exercices.mower2.constants.Commande;
import xebia.exercices.mower2.constants.Orientation;
import xebia.exercices.mower2.constants.Rotation;

public final class UtilsParser {

	public static final Pattern FILE_LINE_HEADER = Pattern.compile("([0-9]*)\\s([0-9]*)");
	public static final Pattern FILE_LINE_TONDEUSE = Pattern.compile("([0-9]*)\\s([0-9]*)\\s([NESO])");

	private UtilsParser() {
	}

	/**
	 * Retourne une liste de commande pour une tondeuse (deplacement,rotation)
	 * ADG. a partir d'une string
	 * 
	 * @param line
	 * @return
	 */
	public static Object[] parseCommande(String line) {
		final List<Object> result = new ArrayList<>();
		if (line != null) {
			line.chars().forEach(code -> {
				Object c = Commande.findByCode(String.valueOf((char) code));
				if (c == null) {
					c = Rotation.findByCode(String.valueOf((char) code));
					if (c != null) {
						result.add(c);
					}
				} else {
					result.add(c);
				}

			});
		}
		return result.toArray();
	}

	/**
	 * Crée un terrain a partir d'une string representant la taille du terrain
	 * 
	 * @param line
	 * @return
	 */
	public static Terrain parseTerrain(String line) {
		if (line != null) {
			final Matcher m = FILE_LINE_HEADER.matcher(line);
			if (m.matches() && m.groupCount() >= 2) {
				Integer sizex = parseInteger(m.group(1)) + 1;
				Integer sizey = parseInteger(m.group(2)) + 1;
				return new Terrain(sizex, sizey);
			}
		}
		return null;
	}

	/**
	 * Crée un terrain a partir d'une string representant la position et
	 * l'orientation d'une tondeuse.
	 * 
	 * @param line
	 * @return
	 */
	public static Tondeuse parseTondeuse(String line) {
		if (line != null) {
			final Matcher m = FILE_LINE_TONDEUSE.matcher(line);
			if (m.matches() && m.groupCount() >= 3) {
				Integer x = parseInteger(m.group(1));
				Integer y = parseInteger(m.group(2));
				Orientation orient = Orientation.findByCode(m.group(3));
				return new Tondeuse(UUID.randomUUID().toString(), orient, new Position(x, y));
			}
		}
		return null;
	}

	public static Integer parseInteger(String i) {
		return Integer.decode(i);
	}

}
