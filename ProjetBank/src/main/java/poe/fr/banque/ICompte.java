package poe.fr.banque;

import java.util.List;

import poe.fr.client.Operation;

public interface ICompte {

	public void setNumero(int unNumero);

	public int getNumero();

	public void setSolde(double unSolde);

	public double getSolde();

	public default void retirer(double pValeur) throws BanqueException {
		this.setSolde(this.getSolde() - pValeur);
	}

	public default void ajouter(double unMontant) {
		this.setSolde(this.getSolde() + unMontant);
	}

	List<Operation> getOperations();

	void setOperations(List<Operation> pDesOperations);

	void ajouteOperation(Operation pUneOperation);

}
