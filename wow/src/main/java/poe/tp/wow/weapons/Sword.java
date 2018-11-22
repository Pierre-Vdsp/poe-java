package poe.tp.wow.weapons;

public class Sword extends Weapon {

	private int length;

	public Sword() {
		this("Standard", 10, 50);
	}

	public Sword(String pName) {
		this(pName, 10, 50);
	}

	public Sword(String pName, int pDamagePoints, int pLength) {
		this.setName(pName);
		this.setDamagePoints(pDamagePoints);
		this.setLength(pLength);
	}

	public void setLength(int pLength) {
		this.length = pLength;
	}

	public int getLength() {
		return this.length;
	}
}
