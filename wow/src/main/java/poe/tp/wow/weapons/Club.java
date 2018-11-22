package poe.tp.wow.weapons;

public class Club extends Weapon {

	private int weight;

	public Club() {
		this("Standard", 10, 50);
	}

	public Club(String pName) {
		this(pName, 10, 50);
	}

	public Club(String pName, int pDamagePoints, int pWeight) {
		this.setName(pName);
		this.setDamagePoints(pDamagePoints);
		this.setWeight(pWeight);
	}

	public void setWeight(int pWeight) {
		this.weight = pWeight;
	}

	public int getWeight() {
		return this.weight;
	}

}
