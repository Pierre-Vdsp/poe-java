package poe.tp.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import poe.tp.jmx.calculatrice.Calculatrice;

public class App {
	private static final Logger LOG = LogManager.getLogger();

	public static void main(String[] args) {
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
		try {
			// Nom de l'objet
			ObjectName name = new ObjectName("fr.jmx:type=Calculatrice");
			// Construction de l'objet
			Calculatrice mbean = new Calculatrice();
			// Inscription de l'objet
			mbs.registerMBean(mbean, name);
			// On attend
			System.out.println("Maintenant, ouvrez un shell et lancez jconsole");
			Thread.sleep(Long.MAX_VALUE);
		} catch (Exception e) {
			App.LOG.error("Message qui gere la pile d'exception", e);
		}
	}
}
