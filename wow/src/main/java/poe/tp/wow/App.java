package poe.tp.wow;

import java.util.Random;

import poe.tp.wow.characters.Characters;
import poe.tp.wow.characters.Hero;
import poe.tp.wow.characters.Monster;

public class App {
	public static void main(String[] args) {

		// ARRAYLIST n'est pas THREAD SAFE
		// VECTOR est THREAD SAFE

		// TIMER CHECK
		long debut = System.currentTimeMillis();

		// Init teams
		Team<Hero> heros = new Team<Hero>();
		heros.createTeamOf("Hero");
		Team<Monster> monsters = new Team<Monster>();
		monsters.createTeamOf("Monster");

		// Matches Ennemies
		Team.setEnnemies(heros.getCharacters(), monsters.getCharacters());

		// tour
		int tour = 0;
		while ((heros.getCharacters().size() > 0) && (monsters.getCharacters().size() > 0)) {
			tour++;
			System.out.println("Tour : " + tour);
			for (Characters c : (new Random().nextInt(2) == 0) ? heros.getCharacters() : monsters.getCharacters()) {
				if ((new Random().nextInt(10) % 10) == 0) {
					c.specialAction();
					c.getEnnemy().specialAction();
				}
				c.attack();
				if ((c.getEnnemy() != null) && (c.getEnnemy().getHealthPoints() > 0) && (c.getHealthPoints() > 0)) {
					c.getEnnemy().attack();
				}
			}
			monsters.checkCharactersDeath();
			heros.checkCharactersDeath();
			Team.setEnnemies(heros.getCharacters(), monsters.getCharacters());
		}
		if (monsters.getCharacters().size() > 0) {
			System.out.println("Monsters win!");
		} else {
			System.out.println("Heros win!");
		}

		// fin timer check
		long fin = System.currentTimeMillis();
		System.out.println("Temps d'execution " + (fin - debut) + " ms.");

	}
}
