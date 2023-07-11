package mypack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

interface Calc {
	public int add(int a, int b);
	// public int sub(int a, int b);
}

public class J8Eg {

	public static void main(String[] args) {
		Calc v = (a, b) -> {
			return (a + b);
		};
		v.add(6, 1);

		Employee e1 = new Employee(1, "Sachin");
		Employee e2 = new Employee(2, "Dohni");
		Employee e3 = new Employee(3, "Gill");

		List<Employee> elist = new ArrayList<>();
		elist.add(e1);
		elist.add(e2);
		elist.add(e3);
		System.out.println(elist);

		Iterator<Employee> i = elist.iterator();
		while (i.hasNext()) {
			System.out.println(i.next());
		}

		elist.forEach(e -> System.out.println(e));

		BiPredicate<String, String> res = (un, pw) -> un.equals(pw);
		System.out.println(res.test("abc", "abc"));

		if (res.test("Priya", "Priyaa")) {
			System.out.println("Welcome ");
		} else {
			System.out.println("Welcome Guest");
		}

		BiPredicate<Long, Long> p1 = (x, y) -> x > y;
		BiPredicate<Long, Long> p2 = (x, y) -> x == y;

		System.out.println(p2.test(10L, 10L));
     
		
		Supplier<String> s = () -> {
			return "Priya";
		};
		System.out.println(s.get());

		Supplier<Integer> s1 = () -> {
			return 123;
		};
		System.out.println(s1.get());

		Function<Integer, String> evenorodd = (num) -> {
			if (num % 2 == 0) {
				return num + " is even .";
			} else {
				return num + " is odd";
			}

		};
		System.out.println(evenorodd.apply(52));

	}

}
/*
 * interface Consumer{ public void accept(List e);
 * 
 * } public void accept(List e) { System.out.println(e); }
 * 
 * Consumer c=(e)-> System.out.println(e); forEach(c)
 * 
 */
