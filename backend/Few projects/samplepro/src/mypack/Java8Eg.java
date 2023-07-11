package mypack;

interface Calculator{
	public int add(int a,int b);
//	public int sub(int a,int b);
}
public class Java8Eg {
	public static void main(String[] main) {
		Calculator v= (a,b)->{return (a+b); };
		System.out.println(v.add(6, 3));
	}

}



//interface Odelu{
//	public void add(int a,int b);
//	
//}
//
//public class Java8Eg{
//	public static void main(String[] args) {
//		
//		Odelu oo=(a,b)->{System.out.println(a+b);};
//		oo.add(7, 4);
//		
//	}
//}
