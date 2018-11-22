package poe.fr.banque;

public interface ICompteASeuil extends ICompte {

	public double getSeuil();

	public void setSeuil(double unSeuil);

	@Override
	public default void retirer(double uneValeur) throws BanqueException {
		double nouveauSolde = this.getSolde() - uneValeur;
		if (nouveauSolde >= this.getSeuil()) {
			this.setSolde(nouveauSolde);
		} else {
			throw new BanqueException("Vous avez atteint le seuil: vous ne pouvez plus retirer.");
		}
	}
}
