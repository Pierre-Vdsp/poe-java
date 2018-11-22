package poe.fr.banque;

public class CompteRemunereASeuil extends CompteRemunere implements ICompteASeuil {

	private double seuil;

	public CompteRemunereASeuil() {
		this(-1, 0, 0, 0);
	}

	public CompteRemunereASeuil(int pUnNumero, double pUnSoldeInitial, double pUnTaux, double pUnSeuil) {
		super(pUnNumero, pUnSoldeInitial, pUnTaux);
		this.setSeuil(pUnSeuil);
	}

	@Override
	public double getSeuil() {
		return this.seuil;
	}

	@Override
	public void setSeuil(double pSeuil) {
		this.seuil = pSeuil;
	}

	@Override
	public String toString() {
		String parentString = super.toString();
		String parsedString = this.getClass().getSimpleName()
				+ parentString.substring(super.getClass().getSimpleName().length(), parentString.length() - 1)
				+ ", seuil: " + this.getSeuil() + "]";
		return parsedString;
	}

}
