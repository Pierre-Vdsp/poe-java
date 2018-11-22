package poe.tp.wow.characters;

import poe.tp.wow.weapons.Sword;

public class Hero extends Characters {

	public Hero() {
		this(30, "Arthur", new Sword("Excalibur"));
	}

	public Hero(int pHealthPoints, String pName, Sword pWeapon) {
		this.setHealthPoints(pHealthPoints);
		this.setName(pName);
		this.setWeapon(pWeapon);
	}

	public void doAGoodDeed() {
		this.getWeapon().setDamagePoints(this.getWeapon().getDamagePoints() + 10);
		System.out.println("Doing Good Deeds n all that : Weapon Damage increased!");
	}

	@Override
	public void specialAction() {
		this.doAGoodDeed();
	}
}
