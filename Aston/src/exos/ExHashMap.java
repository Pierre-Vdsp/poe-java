package exos;

//import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ExHashMap {
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>() ;
		map.put("Bordeau", 33000) ;
		map.put("Toulon", 5) ;
		map.put("Paris", 14) ;
		map.put("Marseille", 7) ;
		map.put("Marseille", 8) ;
		map.put("Thonon", 14) ;
		
		//System.out.println(map.get("Marseille"));
		/*
		ArrayList<Integer> intList = new ArrayList<Integer>() ;
		intList.add(new Integer(1)) ;
		intList.add(new Integer(5)) ;
		intList.add(new Integer(7)) ;
		intList.addAll(Arrays.asList(9, 2, 3, 4, 0));
		
		for (int i : intList) {
			//System.out.println(i);
		}
		Iterator<Integer> it = intList.iterator() ;
		while (it.hasNext()) {
			//System.out.println(it.next());
		}
		ArrayList<String> lst = new ArrayList<String>() ;
		lst.addAll(Arrays.asList("bla", "dla", "tla","vla"));
		Iterator<String> itStg = lst.iterator() ;
		while (itStg.hasNext()) {
			//System.out.println(itStg.next());
		}
		*/
		/*
		HashMap<String, String> names = new HashMap<>() ;
		names.put("luc", "jean") ;
		names.put("michel", "jean") ;
		names.put("vdspl", "pierre") ;
		Iterator<String> itr = names.values().iterator() ;
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		itr = names.keySet().iterator() ;
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		*/
		
		HashSet<String> noms = new HashSet<>() ;
		noms.add("lucdff") ;
		noms.add("vdspla") ;
		noms.add("vdspli") ;
		noms.add("dulacd") ;
		noms.add("duchamps") ;
		Iterator<String> itr = noms.iterator() ;
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
}
