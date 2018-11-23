package poe.tp.jmx.calculatrice;

public interface ICalculatriceMBean {

	void setDernierResultat(double pDernierResultat);

	double getDernierResultat();

	double add(double c1, double c2);

	double sub(double c1, double c2);

	double mult(double c1, double c2);

	double div(double c1, double c2);

}