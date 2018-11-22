package poe.tp.JaxB.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlRootElement(name = "Adresse")
public class Adresse {

	private String ville;
	private String pays;
	private int codePostal;
	private String rue;

	public Adresse() {
		this(null, null, -1, null);
	}

	public Adresse(String pVille, String pPays, int pCodePostal, String pRue) {
		this.ville = pVille;
		this.pays = pPays;
		this.codePostal = pCodePostal;
		this.rue = pRue;
	}

	@XmlAttribute
	public String getVille() {
		return this.ville;
	}

	public void setVille(String pVille) {
		this.ville = pVille;
	}

	@XmlElement
	public String getRue() {
		return this.rue;
	}

	public void setRue(String pRue) {
		this.rue = pRue;
	}

	@XmlAttribute
	public String getPays() {
		return this.pays;
	}

	public void setPays(String pPays) {
		this.pays = pPays;
	}

	@XmlAttribute
	public int getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(int pCodePostal) {
		this.codePostal = pCodePostal;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [city=" + this.ville + ", street=" + this.rue + ", country="
				+ this.pays + ", codePostal=" + this.codePostal + "]";
	}

}
