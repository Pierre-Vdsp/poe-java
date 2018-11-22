package poe.fr.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import poe.fr.banque.CompteRemunereASeuil;
import poe.fr.banque.ICompte;
import poe.fr.client.Operation;

public class TestDB04 {

	public static void main(String[] args) {

		ICompte compteForQuery = new CompteRemunereASeuil(15, 99500, 0.1, 0.0);

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
					.executeQuery("SELECT * FROM banque.operation WHERE compteId=" + compteForQuery.getNumero());

			while (resultat.next()) {

				int numero = resultat.getInt("id");
				String libelle = resultat.getString("libelle");
				double montant = resultat.getDouble("montant");
				/*
				 * String dateRecuperee = resultat.getString("date"); LocalDate date =
				 * LocalDate.now(); if (dateRecuperee != null) { date =
				 * LocalDate.parse(dateRecuperee); }
				 */
				compteForQuery.ajouteOperation(new Operation(numero, libelle, montant, LocalDate.now())); // replace
																											// with date
			}
			System.out.println(compteForQuery);

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
