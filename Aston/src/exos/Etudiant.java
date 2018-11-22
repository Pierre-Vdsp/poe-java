package exos;

public class Etudiant extends Personne {

	protected int num = 12345 ;

	@Override
	public void afficher() {
		// TODO Auto-generated method stub
		System.out.println("Classe Etudiant : " + this.num) ;
	}
}
