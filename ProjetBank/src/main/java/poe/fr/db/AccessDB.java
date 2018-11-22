package poe.fr.db;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import poe.fr.banque.Compte;
import poe.fr.banque.CompteASeuil;
import poe.fr.banque.CompteRemunere;
import poe.fr.banque.CompteRemunereASeuil;
import poe.fr.banque.ICompte;
import poe.fr.client.Client;
import poe.fr.client.Operation;

public class AccessDB {

	public static final String dbDriver = "com.mysql.jdbc.Driver";
	public static final String dbUrl = "jdbc:mysql://localhost/banque?useSSL=false";
	private static String dbLogin = "root";
	private static String dbPwd = "root";
	private static java.sql.Connection connection = null;

	public void seConnecter() throws SQLException {
		try {
			Class.forName(AccessDB.dbDriver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (AccessDB.connection == null)
			AccessDB.connection = DriverManager.getConnection(AccessDB.dbUrl, AccessDB.dbLogin, AccessDB.dbPwd);
	}

	public void seDeconnecter() {
		if (AccessDB.connection != null) {
			try {
				AccessDB.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private List<Operation> basicRecupererOperations(ResultSet resultat) throws SQLException {
		List<Operation> operations = new ArrayList<Operation>();
		while (resultat.next()) {

			int numero = resultat.getInt("id");
			String libelle = resultat.getString("libelle");
			double montant = resultat.getDouble("montant");
			/*
			 * String dateRecuperee = resultat.getString("date"); LocalDate date =
			 * LocalDate.now(); if (dateRecuperee != null) { date =
			 * LocalDate.parse(dateRecuperee); }
			 */
			operations.add(new Operation(numero, libelle, montant, LocalDate.now())); // replace
																						// with date
		}
		if (resultat != null) {
			try {
				resultat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return operations;
	}

	public List<Operation> recupererOperations(int unIdCompte) {
		List<Operation> operations = new ArrayList<Operation>();
		Statement request = null;
		ResultSet resultat = null;
		try {
			this.seConnecter();
			request = AccessDB.connection.createStatement();
			resultat = request.executeQuery("SELECT * FROM banque.operation WHERE compteId=" + unIdCompte);

			operations = this.basicRecupererOperations(resultat);
		} catch (Exception e) {
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
			this.seDeconnecter();
		}
		return operations;
	}

	private List<ICompte> basicRecupererComptes(ResultSet resultat) throws SQLException {
		List<ICompte> comptes = new ArrayList<ICompte>();
		Statement reqOp = null;
		ResultSet resOp = null;
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
			reqOp = AccessDB.connection.createStatement();
			resOp = reqOp.executeQuery("SELECT * FROM banque.operation WHERE compteId=" + c.getNumero());
			c.setOperations(this.basicRecupererOperations(resOp));
			comptes.add(c);
		}
		if (resOp != null) {
			try {
				resOp.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (reqOp != null) {
			try {
				reqOp.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comptes;
	}

	public List<ICompte> recupererComptes(int unIdClient) {
		List<ICompte> comptes = new ArrayList<ICompte>();
		Statement request = null;
		ResultSet resultat = null;
		Statement reqOp = null;
		ResultSet resOp = null;
		try {
			this.seConnecter();
			request = AccessDB.connection.createStatement();
			resultat = request.executeQuery("SELECT * FROM banque.compte WHERE utilisateurId=" + unIdClient);

			comptes = this.basicRecupererComptes(resultat);
		} catch (Exception e) {
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
			if (resOp != null) {
				try {
					resOp.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (reqOp != null) {
				try {
					reqOp.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.seDeconnecter();
		}
		return comptes;
	}

	public List<Client> recupererClients() {
		List<Client> clients = new ArrayList<Client>();
		List<ICompte> comptes = null;
		Statement request = null;
		ResultSet resultat = null;
		Statement reqCompte = null;
		ResultSet resCompte = null;
		Client c = null;
		try {
			this.seConnecter();
			request = AccessDB.connection.createStatement();
			resultat = request
					.executeQuery("SELECT *, YEAR(CURDATE()) - YEAR(dateDeNaissance) AS age FROM banque.utilisateur;");

			while (resultat.next()) {

				comptes = new ArrayList<ICompte>();
				int numero = resultat.getInt("id");
				String nom = resultat.getString("nom");
				String prenom = resultat.getString("prenom");
				int age = resultat.getInt("age") != 0 ? resultat.getInt("age") : 18;

				reqCompte = AccessDB.connection.createStatement();
				resCompte = reqCompte.executeQuery("SELECT * FROM banque.compte WHERE utilisateurId=" + numero);
				comptes = this.basicRecupererComptes(resCompte);

				c = new Client(numero, nom, prenom, age, comptes.toArray(new ICompte[5]));
				clients.add(c);
			}
		} catch (Exception e) {
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
			if (resCompte != null) {
				try {
					resCompte.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (reqCompte != null) {
				try {
					reqCompte.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			this.seDeconnecter();
		}
		return clients;
	}

}
