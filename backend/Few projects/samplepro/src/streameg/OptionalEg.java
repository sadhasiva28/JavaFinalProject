package streameg;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalEg {

	public static void main(String[] args) {
		List<String> strlist = Arrays.asList("Rat","Cat","Lion","","","Tiger","Elephant","Cheeta","Rhino"); 
		System.out.println("List of Strings : " + strlist);
        
		String str = getAllStringValues(strlist);
		System.out.println(str);
	}

	private static String getAllStringValues(List<String> strlist) {
		Optional<String> st=   strlist.stream().filter(str->str.startsWith("Z")).findFirst();
		return st.isPresent() ? st.get() : "No String Present";
	}

}


//(expr)?true   :false





