package mypack;
import java.io.*;
public class DeSerialEg
{
	public static void main(String[] aaa) throws IOException
	{
		try{
		
	
		FileInputStream fis = new FileInputStream("dedalus.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		Employee emp = (Employee)ois.readObject();
		System.out.println("DeSerilized from file dedalus.txt");
		System.out.println(emp.getEno());
		System.out.println(emp.getEname());
		ois.close();
		fis.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file");
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println("No Emp class");
		}

	}
}

















