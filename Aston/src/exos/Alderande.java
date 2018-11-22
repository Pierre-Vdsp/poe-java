package exos;
interface UtilisateurForce {
	public void utilisationForce() ;
	public void serviteurDe() ;
}

class SeigneurSith implements UtilisateurForce {
	@Override
	public void utilisationForce() {
		System.out.println("J'utilise le côté obscur de la force.") ;		
	}
	@Override
	public void serviteurDe() {
		System.out.println("Je sers l'empereur Palpatine.") ;
	}	
}
class ChevalierJedi implements UtilisateurForce {
	@Override
	public void utilisationForce() {
		System.out.println("J'utilise la force pour combattre le côté obscure.") ;		
	}
	@Override
	public void serviteurDe() {
		System.out.println("Je sers la République.") ;
	}
}

public class Alderande {

	public static void main(String[] args) {
		
		UtilisateurForce user = new SeigneurSith() ;
		user.utilisationForce();
		user.serviteurDe();
		user = new ChevalierJedi() ;
		user.utilisationForce();
		user.serviteurDe();
		
	}
}
