package poe.fr.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import poe.fr.banque.BanqueException;
import poe.fr.banque.Compte;
import poe.fr.banque.CompteASeuil;
import poe.fr.banque.CompteRemunere;
import poe.fr.banque.CompteRemunereASeuil;
import poe.fr.banque.ICompte;
import poe.fr.client.Client;

public class TestDB03 {

	public static void main(String[] args) {

		Client clientForQuery = new Client(2, "Fargis", "Denis", 43);

		// Nom du driver pour acceder a la base de donnees.
		// Lire la documentation associee a sa base de donnees pour le connaitre
		final String dbDriver = "com.mysql.jdbc.Driver"; // Nom long d'une classe
		// URL d'access a la base de donnees.
		final String dbUrl = "jdbc:mysql://localhost/banque?useSSL=false"; // banque est le nom de la base
		// Login d'access a la base de donnees.
		final String dbLogin = "root"; // Ou "SA" en HSQL
		// Mot de passe d'access a la base de donnees.
		final String dbPwd = "root"; // Ou "" en HSQL

		try {
			Class.forName(dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Connection connection = null;
		Statement request = null;
		ResultSet resultat = null;

		try {
			connection = DriverManager.getConnection(dbUrl, dbLogin, dbPwd);
			request = connection.createStatement();
			resultat = request
					.executeQuery("SELECT * FROM banque.compte WHERE utilisateurId=" + clientForQuery.getNumero());
			while (resultat.next()) {

				int numero = resultat.getInt("id");
				// String libelle = resultat.getString("libelle");
				double solde = resultat.getDouble("solde");
				double decouvert = resultat.getDouble("decouvert");
				double taux = resultat.getDouble("taux");
				// int cliId = resultat.getInt("utilisateurId");
				ICompte c = new Compte(numero, solde);
				if (taux == 0 && decouvert != 0) {
					c = new CompteASeuil(numero, solde, decouvert);
				} else if (taux != 0) {
					if (decouvert != 0) {
						c = new CompteRemunereASeuil(numero, solde, taux, decouvert);
					} else {
						c = new CompteRemunere(numero, solde, taux);
					}
				}
				try {
					clientForQuery.ajouterCompte(c);
				} catch (BanqueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println(clientForQuery.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (resultat != null) {
				try {
					resultat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (request != null) {
				try {
					request.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
