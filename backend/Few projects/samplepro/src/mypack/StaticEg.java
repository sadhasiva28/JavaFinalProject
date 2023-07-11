package mypack;

 class First{
	
	 int x=20;
	static int y=30;
	
	public static void staticMethod() {
		System.out.println(++y);    //y=y+1
	}

	public void regularMethod() {
		System.out.println(++x);
		System.out.println(++y);
	}
}


public class StaticEg {	

	public static void main(String[] args) {
		First.staticMethod();
		First.staticMethod();
		//StaticEg s1 = new StaticEg();
		//StaticEg s2 = new StaticEg();
		First s1 = new First();
		First s2 = new First();
		s1.regularMethod();
		s2.regularMethod();
	}

}
