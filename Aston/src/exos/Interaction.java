package exos;

import java.io.File;

public class Interaction {
	public static void main(String[] args) {
		File fichier1 = new File ("C:\\Users\\Pierre V\\Desktop");
		
		System.out.println("Nom : " + fichier1.getName());
		System.out.println("Chemin : " + fichier1.getPath());
		System.out.println("Chemin complet : " + fichier1.getAbsolutePath());
		System.out.println("Parent : " + fichier1.getParent());
		System.out.println("Existe : " + fichier1.exists());
		System.out.println("Écriture : " + fichier1.canWrite());
		System.out.println("Lecture : " + fichier1.canRead());
		System.out.println("Répertoire : " + fichier1.isDirectory());
		System.out.println("Fichier : " + fichier1.isFile());
		System.out.println("Absolu : " + fichier1.isAbsolute());
		System.out.println("Taille : " + fichier1.length());
	}
}
