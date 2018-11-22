package poe.fr.testDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import poe.fr.client.Client;

public class TestDB02 {

	public static void main(String[] args) {

		List<Client> clientsFromDB = new ArrayList<Client>();

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
					.executeQuery("SELECT *, YEAR(CURDATE()) - YEAR(dateDeNaissance) AS age FROM banque.utilisateur;");
			while (resultat.next()) {

				int numero = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				int age = resultat.getInt("age") != 0 ? resultat.getInt("age") : 18;
				clientsFromDB.add(new Client(numero, nom, prenom, age));
			}
			System.out.println(clientsFromDB.toString());
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
