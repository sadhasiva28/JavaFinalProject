package mypack2;

import java.io.Serializable;
import java.util.Comparator;

public class Student implements Comparable<Student>,Serializable{
	private int sid;
	private String sname;
	private transient int age; 
	private int marks;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sname, int age, int marks) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.age = age;
		this.marks = marks;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", age=" + age + ", marks=" + marks + "]";
	}

	@Override
	public int compareTo(Student s1) {
		
		return this.sid - s1.sid;
	}
	
	//Anonyomous class
	public static Comparator<Student> nameComparator = new Comparator<Student>() {

		@Override
		public int compare(Student s1, Student s2) {
			
			return (s1.getSname().compareTo(s2.getSname()));
		}
		
		
	};

	//Anonyomous class
		public static Comparator<Student> marksComparator = new Comparator<Student>() {

			@Override
			public int compare(Student s1, Student s2) {
				
				return (s1.getMarks() - s2.getMarks());
			}
			
			
		};
}
