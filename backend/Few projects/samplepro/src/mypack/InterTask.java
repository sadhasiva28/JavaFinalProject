package mypack;

interface StudentDetails {
    int m1 = 89;
    int m2 = 90;

   public void Marks();
}

interface Details extends StudentDetails {
    public void Marks() ;
}

class Record implements Details {
    public void Marks() {
        System.out.println("The student records = " + m2);
    }
}

public class InterTask {
    public static void main(String[] args) {

        Record r1 = new Record();
        r1.Marks();
    }
}
