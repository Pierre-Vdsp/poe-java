package poe.tp.lecture_ecriture.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UtilisateurWriter {

	public static void writeUtilisateur(String unNomDeFichier, List<String> desNoms, List<String> desPrenoms,
			int combien) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(unNomDeFichier + ".csv"))) {
			int index = 0;
			do {
				String genre = (new Random().nextInt(2) == 0) ? "M" : "Mme";
				Collections.shuffle(desNoms);
				Collections.shuffle(desPrenoms);
				writer.write(index + ";" + genre + ";" + desNoms.get(new Random().nextInt(desNoms.size())) + ";"
						+ desPrenoms.get(new Random().nextInt(desPrenoms.size())) + System.lineSeparator());
				index++;
				combien--;
			} while (combien > 0);
		}
	}
}
