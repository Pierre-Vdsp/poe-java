package poe.fr.client;

import java.util.Hashtable;
import java.util.Map;

import poe.fr.banque.BanqueException;
import poe.fr.banque.ICompte;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Map<Integer, ICompte> comptes = new Hashtable<Integer, ICompte>();

	public Client() {
		this(0, "", "", 0);
	}

	public Client(int unNumero, String unNom, String unPrenom, int unAge) {
		this(unNumero, unNom, unPrenom, unAge, new ICompte[5]);
	}

	public Client(int unNumero, String unNom, String unPrenom, int unAge, ICompte[] desComptes) {
		this.nom = unNom;
		this.prenom = unPrenom;
		this.age = unAge;
		this.numero = unNumero;
		this.setComptes(desComptes);
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String unNom) {
		this.nom = unNom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String unPrenom) {
		this.prenom = unPrenom;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int unAge) {
		this.age = unAge;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int unNumero) {
		this.numero = unNumero;
	}

	public ICompte[] getComptes() {
		return this.comptes.values().toArray(new ICompte[5]);
	}

	public void setComptes(ICompte[] desComptes) {
		for (ICompte unCompte : desComptes) {
			try {
				if (unCompte != null)
					this.ajouterCompte(unCompte);
			} catch (BanqueException bE) {
				System.out.println(bE.getMessage());
			}
		}
	}

	public ICompte getCompte(int unNumero) {
		return this.comptes.get(unNumero);
	}

	public void ajouterCompte(ICompte unCompte) throws BanqueException {
		if (this.comptes.size() < 4) {
			this.comptes.put(unCompte.getNumero(), unCompte);
		} else {
			throw new BanqueException("Il n'y a plus de place: vous ne pouvez plus rajouter d'autres comptes.");
		}
	}

	@Override
	public String toString() {
		String client = "Nom: " + this.nom + ", Numero: " + this.numero;
		for (ICompte c : this.comptes.values()) {
			client += c != null && c.getNumero() != 0 ? ", " + c.toString() : "";
		}
		return client;
	}

}
