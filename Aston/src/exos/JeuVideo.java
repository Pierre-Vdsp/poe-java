package exos;

//import java.util.Arrays;

public class JeuVideo {

	private String[] consoles ;
	private String titre ;
	
	public JeuVideo (String consoles[], String titre) {
		this.titre = titre ;
		this.consoles = consoles ;
	}
	
	public String[] getConsoles() {
		return consoles;
	}
	public void setConsoles(String[] consoles) {
		this.consoles = consoles;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	/*
	@Override
	public String toString() {
		return "JeuVideo [consoles=" + Arrays.toString(consoles) + ", titre=" + titre + "]";
	}
	*/
	public String toString() {
		StringBuffer buff = new StringBuffer () ;
		buff.append(", Consoles : ") ;
		for (int i = 0 ; i < consoles.length ; i++) {
			buff.append( (i == 0) ? consoles[i] : ", " + consoles[i]) ;
		}
		return ("Titre: " + this.titre + buff.toString()) ; 
	}
	

	public boolean equals(Object obj) {
		return (obj instanceof JeuVideo) && ((JeuVideo) obj).getTitre().equals(this.titre) ;		
	}
	public static void main(String[] args) {
		String consoles[] = {"PS3", "PC", "XBOX ONE"} ;
		JeuVideo unJeu = new JeuVideo(consoles, "RDR2")  ;
		JeuVideo unAutreJeu = new JeuVideo(consoles, "RDR")  ;
		
		System.out.println(unJeu);
		System.out.println(unAutreJeu);
		
		System.out.println(unJeu.getTitre() + " equals " + unAutreJeu.getTitre() + " : " + unJeu.equals(unAutreJeu));
	}
}
