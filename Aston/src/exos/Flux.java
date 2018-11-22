package exos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream ;
import java.io.FileReader;
import java.io.IOException ;
import java.io.PrintWriter ;

public class Flux {

	// fileinputstream, fileoutputstream, printwriter, ioexception
	
	public static void main (String[] args) {
		String prenomEtudiant = "Laurent" ;
		String nomEtudiant = "Martin" ;
		String note = "A" ;
		
		try {
			PrintWriter sortie = new PrintWriter (new FileOutputStream("Etudiant.txt")) ;
			sortie.print(prenomEtudiant + "\n") ;
			sortie.print(nomEtudiant + "\n") ;
			sortie.print(note + "\n") ;
			sortie.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} 
		
		try {
			FileReader reada = new FileReader ("Etudiant.txt") ;
			StringBuffer str = new StringBuffer() ;
			str.append("");
			
		    char [] characters = new char[50];
		    reada.read(characters);
		      
		    for(char c : characters)
		    	str.append(c) ;
		      
			reada.close() ;
			System.out.println(str.toString()) ;
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
}
