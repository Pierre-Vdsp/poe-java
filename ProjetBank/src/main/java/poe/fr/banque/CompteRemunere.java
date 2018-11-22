package poe.fr.banque;

public class CompteRemunere extends Compte implements ICompteRemunere {

	private double taux;

	public CompteRemunere() {
		this(-1, 0, 0);
	}

	public CompteRemunere(int pUnNumero, double pUnSoldeInitial, double pUnTaux) {
		super(pUnNumero, pUnSoldeInitial);
		this.setTaux(pUnTaux);
	}

	@Override
	public double getTaux() {
		return this.taux;
	}

	@Override
	public void setTaux(double pTaux) {
		this.taux = pTaux >= 0 && pTaux <= 1 ? pTaux : 0;
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		String parsedString = this.getClass().getSimpleName()
				+ parentString.substring(super.getClass().getSimpleName().length(), parentString.length() - 1)
				+ ", taux: " + this.getTaux() + "]";
		return parsedString;
	}
}
