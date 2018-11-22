package exos;

public class CreateChien {
	
	private Chien chien ;
	
	public CreateChien (String nom, String couleur) {
		this.chien = new Chien() ;
		this.chien.setCouleur(couleur);
		this.chien.setName(nom);
	}
	
	public void printChien() {
		System.out.println(this.chien.getName() + " est " + this.chien.getCouleur());
	}
}
