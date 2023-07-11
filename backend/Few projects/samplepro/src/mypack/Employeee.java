package mypack;

import java.io.Serializable;

public class Employeee implements Serializable {
	private int eno;
	private String ename;

	public Employeee() {
		super();
		
	}

	public Employeee(int eno, String ename) {
		super();
		this.eno = eno;
		this.ename = ename;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + "]";
	}

	public String getDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	public void showIDCard() {
		// TODO Auto-generated method stub
		
	}

}
