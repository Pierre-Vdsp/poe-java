package poe.tp.wow.characters;

import poe.tp.wow.weapons.Club;
import poe.tp.wow.weapons.Weapon;

public class Monster extends Characters {

	public Monster() {
		this(25, "Grum", new Club("L'Abattoir"));
	}

	public Monster(int pHealthPoints, String pName, Weapon pWeapon) {
		this.setHealthPoints(pHealthPoints);
		this.setName(pName);
		this.setWeapon(pWeapon);
	}

	public void feed() {
		this.setHealthPoints(this.getHealthPoints() + 10);
		System.out.println("Feeding on your ennemies ? Health Points increased!");
	}

	@Override
	public void specialAction() {
		this.feed();
	}
}
