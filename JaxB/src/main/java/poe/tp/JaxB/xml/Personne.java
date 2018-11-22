package poe.tp.JaxB.xml;

import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Personne")
public class Personne {

	private List<Adresse> adresses = new Vector<Adresse>();
	private LocalDate dateNaissance;
	private String nom;
	private String prenom;

	public Personne() {
		this.setDateNaissance(LocalDate.now());
		this.setNom(null);
		this.setPrenom(null);
		this.setAdresses(new Vector<Adresse>());
	}

	public Personne(List<Adresse> pAdresses, LocalDate pDateNaissance, String pNom, String pPrenom) {
		this.adresses = pAdresses;
		this.dateNaissance = pDateNaissance;
		this.nom = pNom;
		this.prenom = pPrenom;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [nom=" + this.nom + ", prenom=" + this.prenom + ", dateNaissance="
				+ this.dateNaissance + ", adresses=" + this.adresses + "]";
	}

	@XmlElement
	public String getNom() {
		return this.nom;
	}

	public void setNom(String pNom) {
		this.nom = pNom;
	}

	@XmlElement
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String pPrenom) {
		this.prenom = pPrenom;
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	@XmlElement
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(LocalDate pLocalDate) {
		this.dateNaissance = pLocalDate;
	}

	@XmlElement
	public List<Adresse> getAdresses() {
		return this.adresses;
	}

	public void setAdresses(List<Adresse> pAdresses) {
		this.adresses = pAdresses;
	}
}
