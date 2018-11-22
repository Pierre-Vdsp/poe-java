package exos;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class EntrerNumero {

	static Scanner lecture = new Scanner(System.in);
	static ArrayList<Integer> tab = new ArrayList<Integer>() ;
	
	public static void main(String[] args) {
		
		// SCANNER SCANNING
		System.out.println("Entrez un numéro de votre choix, 0 pour finir.");
		int in = lecture.nextInt() ;
		while(in != 0) {
			tab.add(in) ;
			in = lecture.nextInt() ;
		}

		System.out.println("------------");
		
		//P'TIT ITERATOR DES FAMILLES
		ListIterator<Integer> it = tab.listIterator() ;
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("------------");
		
		// REMOVE STUFF
		System.out.println("Entrez un numéro à supprimer, 0 pour arrêter.");
		in = lecture.nextInt() ;
		while(in != 0) {
			tab.remove(new Integer(in)) ;
			in = lecture.nextInt() ;
		}
		lecture.close();
		// PRINT RES
		for(int i : tab) {
			System.out.println(i) ;
		}
	}
}
