import java.lang.*;
class MyClass {
    static int a;
    int b = 23;

    public void output1() {
        int c = 23;
        System.out.println("This is the value=" + c);
        System.out.println("the value of a: " + a);
    }

    public void output2() {
        int z = 23;
        System.out.println("This is the value=" + z);
        System.out.println("the value of b: " + b);
    }
}

public class Child {
    public static void main(String[] args) {
        MyClass mc = new MyClass();
        mc.output1();
        mc.output2();
        System.out.println(new MyClass().a);
        System.out.println(new MyClass().b);
    }
}