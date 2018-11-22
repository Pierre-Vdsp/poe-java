package poe.tp.lecture_ecriture;

import java.io.IOException;
import java.util.List;
import java.util.Vector;

import poe.tp.lecture_ecriture.io.NomPrenomReader;
import poe.tp.lecture_ecriture.io.UtilisateurWriter;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		List<String> noms = new Vector<String>();
		List<String> prenoms = new Vector<String>();

		noms.add("Max");
		prenoms.add("Max");
		noms.add("Lando");
		noms.add("Mad");
		prenoms.add("Mad");
		noms.add("Bel");
		noms.add("Mando");
		prenoms.add("Alfonsse");

		try {
			UtilisateurWriter.writeUtilisateur("ids", noms, prenoms, 10);
			for (String name : NomPrenomReader.readNom())
				System.out.println(name);
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}
