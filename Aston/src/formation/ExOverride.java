package formation;

import formation.ExFunctionInterface.Calculer;

public class ExOverride {

	public static void main(String[] args) {
		
		ExFunctionInterface client = new ExFunctionInterface() ;
		
		// client
		int rep = ExOverride.calculerService(3, 4, (p, q) -> p*q) ;
		System.out.println("Reponse : " + rep);
	}

	public static int calculerService(int i, int j, Calculer calculer) {
		return calculer.calcul(i,  j);
	}
}