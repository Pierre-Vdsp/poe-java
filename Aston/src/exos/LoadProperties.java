package exos;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class LoadProperties {

	  public static void main(String[] args) {
		
		Properties prop = new Properties();
		InputStream input = null ;
		Enumeration<Object> keys = null ;
		HashMap<Object, Object> mysql = new HashMap<>() ;
		HashMap<Object, Object> oracle = new HashMap<>() ;
		
		try {
			input = new FileInputStream("db.properties");
			prop.load(input);
			
			keys = prop.keys() ;
			Object key = null ;
			
			while (keys.hasMoreElements()) {
				key = keys.nextElement() ;
				if (key.toString().indexOf("MYSQL") != -1) {
					mysql.put(key, prop.get(key)) ;
				} else {
					oracle.put(key, prop.get(key)) ;					
				}
			}
			System.out.println("MYSQL: " + mysql.toString());
			System.out.println("\nORACLE: " + oracle.toString());
			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	  }
}
