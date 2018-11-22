package exos;

public class RunEncap {

	public static void main(String[] args) {
		
		EncapTest test = new EncapTest() ;
		System.out.println(test.getAge()) ;
		test.setAge(10) ;
		System.out.println(test.getAge()) ;

	}

}
