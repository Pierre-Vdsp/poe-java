package poe.tp.JaxB;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import poe.tp.JaxB.xml.Adresse;
import poe.tp.JaxB.xml.Personne;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		List<Adresse> adresses = new Vector<Adresse>();

		adresses.add(new Adresse("CityTown", "PaysLand", 45665, "DelaRue Street"));
		adresses.add(new Adresse("Villeage", "CountryRoad", 99999, "rue Ostreet"));

		Personne pers = new Personne(adresses, LocalDate.now(), "Vdspl", "Pierre");

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Personne.class, Adresse.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			jaxbMarshaller.marshal(pers, new File("monFichier.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Personne.class, Adresse.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Personne personneLue = (Personne) jaxbUnmarshaller.unmarshal(new File("monFichier.xml"));
			System.out.println(personneLue);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
