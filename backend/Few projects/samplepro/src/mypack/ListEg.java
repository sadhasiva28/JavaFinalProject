package mypack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class ListEg {

	public static void main(String[] args) {

		List l = new LinkedList<>();
		l.add(100);   //Auto- Boxing
		l.add(200);
		l.add(200);
		l.add("Dilli");
		l.add("Priya");
		l.add(null);
		System.out.println(l);
		
		/*Set s = new HashSet();
		s.add(100);   //Auto- Boxing
		s.add(200);
		s.add(200);
		s.add("Dilli");
		s.add("Priya");
		s.add(null);
		System.out.println(s);
		
		Set s1 = new TreeSet();
		//s1.add(100);   //Auto- Boxing
		//s1.add(200);
		//s1.add(200);
		s1.add("Dilli");
		s1.add("Priya");
		s1.add("Bala");
		//s1.add(null);
		System.out.println(s1);
		
		Map m = new HashMap();
		m.put(1, 100);
		m.put(2, 200);
		m.put(3, 200);
		m.put(4, "Dilli");
		m.put(5, "Priya");
		m.put(6, null);
		m.put(null, null);
		m.put(null, null);
		m.put(null, "Arun");
		System.out.println(m);*/
	}

}
