package exos;

import java.util.StringTokenizer;

public class Chaine {
	public static void main(String[] args) {
		String str = new String("J'aime les chats.");
		String felix = new String("Et j'aime les chiens.");
		String str2 = "J'adore aller faire les courses";
		String numero = "020002020 est mon numéro de téléphone";
		System.out.println(str);
		System.out.println(felix);
		System.out.println();
		System.out.println(str2);
		System.out.println(numero);
		System.out.println();
		System.out.println("Mon chat ne fait que dormir. " + str);
		System.out.println(str+ str2);
		String s = new String("Mon nom est personne.") ;
		StringTokenizer str3 = new StringTokenizer(s) ;
		System.out.println("Nombre de mots : " + str3.countTokens());
		while (str3.hasMoreTokens()) {
			System.out.println(str3.nextToken());
		}
		
		String months[] = {"Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre", "Octobre", "Novembre", "Decembre"} ;
		int monthNb = 8 ;
		System.out.println(months[monthNb-1]) ;
	}
}
