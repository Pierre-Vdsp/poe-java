package exos;

public class Lyceen extends Eleve {

	private float moyTotal ;
	private boolean admission ;
	
	public Lyceen(float maths, float anglais) {
		this.maths = maths;
		this.anglais = anglais;
		moyTotal = moyExam() ;
		admission = evalAdmission() ;
	}
	
	@Override
	public float moyExam() {
		return ( (anglais + maths) / 2);
	}

	@Override
	public void affiche() {
		System.out.println(moyTotal + " de moyenne.");
		System.out.println( (admission)? "Mission Success!" : "Mission Failed" );
	}

	public void affiche(boolean admission) {
		System.out.println(moyTotal + " de moyenne.");
		System.out.println( (admission)? "Mission Success!" : "Mission Failed" );
	}
	
	public boolean evalAdmission() {
		return moyTotal >= 10.00 ;
	}

}
