package exos;

import java.util.ArrayList;

public class SetsArrayListsAndMaps {

	
	public static void main (String[] args) {
		// TOUJOURS un type OBJECT entre CHEVRONS
		ArrayList<Integer> liste = new ArrayList<Integer>() ;
		liste.add(new Integer(7));
		System.out.println(liste.size()) ;
		liste.set(0, 23) ;
		System.out.println(liste.get(0)) ;
	}
	
}
