package poe.fr.client;

import java.time.LocalDate;

public class Operation {

	private int numero;
	private String libelle;
	private double montant;
	private LocalDate date;

	public Operation() {
		this(0, "standard", 0, LocalDate.now());
	}

	public Operation(int pNumero, String pLibelle, double pMontant, LocalDate pDate) {
		this.numero = pNumero;
		this.libelle = pLibelle;
		this.montant = pMontant;
		this.date = pDate;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int pNumero) {
		this.numero = pNumero;
	}

	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String pLibelle) {
		this.libelle = pLibelle;
	}

	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double pMontant) {
		this.montant = pMontant;
	}

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(LocalDate pDate) {
		this.date = pDate;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [numero=" + this.getNumero() + ", libelle=" + this.getLibelle()
				+ ", date=" + this.getDate().toString() + "]";
	}
}
