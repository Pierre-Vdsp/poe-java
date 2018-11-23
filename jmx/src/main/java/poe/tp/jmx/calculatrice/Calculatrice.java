package poe.tp.jmx.calculatrice;

public class Calculatrice implements ICalculatriceMBean {

	private double dernierResultat;

	public Calculatrice() {
		this.setDernierResultat(0D);
	}

	@Override
	public void setDernierResultat(double pDernierResultat) {
		this.dernierResultat = pDernierResultat;
	}

	@Override
	public double getDernierResultat() {
		return this.dernierResultat;
	}

	@Override
	public double add(double c1, double c2) {
		return c1 + c2;
	}

	@Override
	public double sub(double c1, double c2) {
		return c1 - c2;
	}

	@Override
	public double mult(double c1, double c2) {
		return c1 * c2;
	}

	@Override
	public double div(double c1, double c2) {
		return c1 / c2;
	}
}
