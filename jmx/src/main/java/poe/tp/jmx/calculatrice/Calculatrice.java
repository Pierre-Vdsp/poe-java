package poe.tp.jmx.calculatrice;

public class Calculatrice {

	private double dernierResultat;

	public Calculatrice() {
		this.setDernierResultat(0D);
	}

	public void setDernierResultat(double pDernierResultat) {
		this.dernierResultat = pDernierResultat;
	}

	public double getDernierResultat() {
		return this.dernierResultat;
	}
}
