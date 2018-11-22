package exos;

public class ToStringify {
	
	public String stringify(String[] agrv) {
		String res = "" ;
		for (int i = 0 ; i < agrv.length ; i++) {
			res = (i == 0) ? agrv[i] : res + ", " + agrv[i] ;
		}
		return res;		
	}
}
