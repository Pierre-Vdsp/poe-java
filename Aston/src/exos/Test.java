package exos;

public class Test implements CalculNote {
	public float note ;
	float examen [] = { 6, 8.5f } ;
	
	public Test() {
		calcNote() ;
	}
	/* (non-Javadoc)
	 * @see exos.CalculNote#calcNote()
	 */
	@Override
	public void calcNote () {
		float tmp = 0 ;
		
		for(int i=0; i<examen.length; i++) {
			tmp += examen[i] ;
		}
		this.note = (tmp / examen.length) ;
	}
	public String stringifyPlusDate(String[] agrv) {
		ToStringify texter = new ToStringify() ; 
		return texter.stringify(agrv) + " - TODAY" ;		
	}
}
