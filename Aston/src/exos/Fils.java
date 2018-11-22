package exos;

class Pere {
	void alpha() {
		System.out.println("Je me trouve dans la classe Père");
	}
}
public class Fils extends Pere {
	void beta() {
		System.out.println("Je me trouve dans la classe Fils");
	}/*
	public static void main(String[] args) {
		Pere obj = new Fils(); // upcasting
		obj.alpha();
		
		Fils obj1 = (Fils)obj; // downcasting
		obj1.beta();
	}*/
}