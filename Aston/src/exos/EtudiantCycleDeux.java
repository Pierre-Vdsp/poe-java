package exos;

public class EtudiantCycleDeux extends Etudiant {

	protected String cursus = "Master 2" ;
	
	public EtudiantCycleDeux() {
		super() ;
	}
	
	public void afficher() {
		System.out.println("Classe EtudiantCycleDeux : " + cursus) ;
		System.out.println("Num�ro d'�tudiant : " + num +"\n") ;
	}
}
