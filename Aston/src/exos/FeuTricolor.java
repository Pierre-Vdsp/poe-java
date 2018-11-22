package exos;

import java.math.BigDecimal;

public class FeuTricolor {

	private COULEUR couleur ;

	public COULEUR getCouleur() {
		return couleur;
	}

	public void setCouleur(COULEUR couleur) {
		this.couleur = couleur;
	}
	
	public static void main(String[] args) {
		
		FeuTricolor feu = new FeuTricolor() ;
		feu.setCouleur(COULEUR.ROUGE) ;
		System.out.println(feu.getCouleur());
		for (COULEUR c : COULEUR.values())
			if (c == COULEUR.ROUGE) {
				System.out.println(COULEUR.arret());
			}
		
        Animal anim = Animal.TIGRE;
        System.out.println("Anim est un "+anim.getNom() + (anim.isDomestique()?" (domestique)":" (sauvage)"));
        String env = anim.getEnvironnement();
        if (env!=null)
            System.out.print(" vivant dans un milieu "+env);
        
        BigDecimal montant = new BigDecimal("150");

        for (Remise remise : Remise.values())
	        System.out.println(remise + " " + remise.calculer(montant));
        
	}
}
