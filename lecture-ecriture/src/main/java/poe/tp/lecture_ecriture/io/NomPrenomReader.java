package poe.tp.lecture_ecriture.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

public class NomPrenomReader {

	private final static String pathNom = "ids.csv";
	private final static String pathPrenom = "prenom.txt";

	private static List<String> readFichier(String unNomDeFichier) throws IOException {
		List<String> resultats = new Vector<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(unNomDeFichier))) {
			do {
				resultats.add(reader.readLine());
			} while (resultats.get(resultats.size() - 1) != null);

			resultats.remove(resultats.size() - 1);

		}
		return resultats;
	}

	public static List<String> readNom() throws IOException {
		return NomPrenomReader.readFichier(NomPrenomReader.pathNom);
	}

	public static List<String> readPrenom() throws IOException {
		return NomPrenomReader.readFichier(NomPrenomReader.pathPrenom);
	}
}
