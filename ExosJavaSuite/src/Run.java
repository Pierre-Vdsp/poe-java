
import fr.dessin.Point2D;
import fr.dessin.Point3D;

public class Run {

	public static void main(String[] args) {

		System.out.println("Nb d'objets Point2D instanciés : " + Point2D.getCompteur());

		Point2D p1 = new Point2D(15, 4);
		Point2D p2 = new Point2D(1, 1);

		p1.afficher();
		p2.afficher();

		p1.translater(p2.getX(), p2.getY());

		p1.afficher();

		System.out.println("Nb d'objets Point2D instanciés : " + Point2D.getCompteur());

		Point3D p3 = new Point3D();
		Point3D p4 = new Point3D(1, 2, 3);

		p3.afficher();
		p3.translater(p4.getX(), p4.getY(), p4.getZ());
		p3.afficher();
	}

}
