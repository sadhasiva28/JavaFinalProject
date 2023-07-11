package mypack;
import java.io.*;
public class SerialEg
{
	public static void main(String[] aaa) throws IOException
	{
		try{
		Employee emp = new Employee(1012,"Pavithra");
	
		FileOutputStream fos = new FileOutputStream("dedalus.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(emp);
		System.out.println("Serilized to file dedalus.txt");
		oos.close();
		fos.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file");
		}
	}
}

















