package poe.fr.banque;

public interface ICompteRemunere extends ICompte {

	public double getTaux();

	public void setTaux(double unTaux);

	public default double calculerInterets() {
		return this.getTaux() * this.getSolde();
	}

	public default void verserInterets() {
		this.setSolde(this.getSolde() + this.calculerInterets());
	}
}
