package mypack;

abstract class MainClass{
    public abstract void smallClass();
}

class OuterFunction{
    static int num = 23;
    static int instanceVariable = 24;

    public static void innerMethod() {
        System.out.println("The number is " + num);
    }

    class MainMethod extends MainClass{
        @Override
        public void smallClass() {
            System.out.println("The value of the instance variable is " + instanceVariable);
        }
    }
}

public class OuterClass {
    public static void main(String[] args) {
        OuterFunction of = new OuterFunction();
        of.innerMethod();
        
        OuterFunction.MainMethod mm = of.new MainMethod();
        mm.smallClass();
    }
}
