package poe.tp.wow.characters;

import poe.tp.wow.weapons.Weapon;

public abstract class Characters {

	private int healthPoints;
	private String name;
	private Weapon weapon;
	private Characters ennemy;

	public Characters getEnnemy() {
		return this.ennemy;
	}

	public void setEnnemy(Characters pEnnemy) {
		this.ennemy = pEnnemy;
	}

	public void attack() {
		if (this.getHealthPoints() > 0 && this.getEnnemy() != null && this.getEnnemy().getHealthPoints() > 0) {

			String desc = this.getClass().getSimpleName() + " (" + this.getName() + ") ";
			desc += "attacks " + this.getEnnemy().getClass().getSimpleName() + " (" + this.getEnnemy().getName()
					+ ") : " + this.getWeapon().getDamagePoints() + " damage points! ";

			System.out.println(desc);

			this.getEnnemy().takeDamage(this.getWeapon().getDamagePoints());

			this.getWeapon().setState(this.getWeapon().getState() + 1);

		}
	}

	public void takeDamage(int damage) {
		this.setHealthPoints(this.getHealthPoints() - damage);

		if (this.getHealthPoints() > 0) {
			System.out.println(this.getHealthPoints() + " health points remaining. ");
		} else {
			System.out.print(this.getClass().getSimpleName() + " dies! ");
		}

	}

	public abstract void specialAction();

	public void setHealthPoints(int pHealthPoints) {
		this.healthPoints = pHealthPoints >= 0 ? pHealthPoints : 0;
	}

	public int getHealthPoints() {
		return this.healthPoints;
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getName() {
		return this.name;
	}

	public void setWeapon(Weapon pWeapon) {
		this.weapon = pWeapon;
	}

	public Weapon getWeapon() {
		return this.weapon;
	}
}
