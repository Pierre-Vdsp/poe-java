package poe.tp.wow.weapons;

public abstract class Weapon {

	private String name;
	private int damagePoints;
	private int state = 0;

	public int getState() {
		return this.state;
	}

	public void setState(int pState) {
		this.state = pState;
	}

	public void setDamagePoints(int pDamagePoints) {
		this.damagePoints = pDamagePoints;
	}

	public int getDamagePoints() {
		if (this.state < 3) {
			return this.damagePoints;
		} else if (this.state > 2 && this.state < 6) {
			return this.damagePoints / 2;
		} else {
			return 0;
		}
	}

	public void setName(String pName) {
		this.name = pName;
	}

	public String getName() {
		return this.name;
	}
}
