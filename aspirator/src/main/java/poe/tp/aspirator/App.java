package poe.tp.aspirator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Object[] lines;
		// Aspi asaspi = new Aspi(10, 10, 5, 5, 'N');
		/*
		 * Path chemin = Paths.get('file piath'); List<String> allLines = null ; try
		 * catch : allLines = Files.readAllLines(chemin); syso(allLines);
		 * Files.newBufferedReader(path)
		 */

		try {
			Stream<String> stream = Files.lines(Paths.get("Aspirateur.txt"));
			lines = stream.toArray();
			String[] tab1 = ((String) lines[0]).split(" ");
			String[] tab2 = ((String) lines[1]).split(" ");
			Aspi asaspi = new Aspi(Integer.valueOf(tab1[0]), Integer.valueOf(tab1[1]), Integer.valueOf(tab2[0]),
					Integer.valueOf(tab2[1]), tab2[2].charAt(0));
			for (int i = 0; i < ((String) lines[2]).length(); i++)
				asaspi.charCommand(((String) lines[2]).charAt(i));

			stream.close();
			asaspi.afficher();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * asaspi.charCommand('D'); asaspi.charCommand('A'); asaspi.charCommand('D');
		 * asaspi.charCommand('A'); asaspi.charCommand('D'); asaspi.charCommand('A');
		 * asaspi.charCommand('D'); asaspi.charCommand('A'); asaspi.charCommand('A');
		 *
		 * asaspi.afficher();
		 */
	}
}
