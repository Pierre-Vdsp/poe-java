package poe.fr.banque;

import java.util.ArrayList;
import java.util.List;

import poe.fr.client.Operation;

public class Compte implements ICompte {

	private double solde;
	private int numero;
	private List<Operation> operations = new ArrayList<Operation>();

	public Compte() {
		this(-1, 0d);
	}

	public Compte(int unNumero, double unSoldeInitial) {
		this.solde = unSoldeInitial;
		this.numero = unNumero;
	}

	@Override
	public int getNumero() {
		return this.numero;
	}

	@Override
	public double getSolde() {
		return this.solde;
	}

	@Override
	public void setSolde(double solde) {
		this.solde = solde;
	}

	@Override
	public String toString() {
		String compte = this.getClass().getSimpleName() + " [solde=" + this.solde + ", numero=" + this.numero + "]";
		for (Operation op : this.getOperations()) {
			compte += op != null && op.getNumero() != 0 ? ", " + op.toString() : "";
		}
		return compte;
	}

	@Override
	public void setNumero(int pUnNumero) {
		this.numero = pUnNumero;
	}

	@Override
	public List<Operation> getOperations() {
		return this.operations;
	}

	@Override
	public void setOperations(List<Operation> desOperations) {
		this.operations = desOperations;
	}

	@Override
	public void ajouteOperation(Operation uneOperation) {
		this.operations.add(uneOperation);
	}
}
