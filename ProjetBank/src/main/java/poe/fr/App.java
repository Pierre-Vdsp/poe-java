package poe.fr;

import java.util.List;

import poe.fr.client.Client;
import poe.fr.db.AccessDB;

public class App {
	public static void main(String[] args) {

		AccessDB dao = new AccessDB();
		List<Client> clients = dao.recupererClients();

		for (Client c : clients) {
			System.out.println("\n>> Client:");
			System.out.println(c.toString() + "\n");
		}
	}
}
