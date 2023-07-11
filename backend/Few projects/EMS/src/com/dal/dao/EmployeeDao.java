package com.dal.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.util.MyDbConnection;
import com.dedalus.model.Employee;

public class EmployeeDao {
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
public void insertEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into DEDAEMP values(?,?)");
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dedaemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public void updateEmployee(int empno, Employee emp) {
	    con = MyDbConnection.getMyConnection();
	    try {
	        ps = con.prepareStatement("UPDATE dedaemp SET ename = ? WHERE empno = ?");
	        ps.setString(1, emp.getEname());
	        ps.setInt(2, empno);
	        int noofrows = ps.executeUpdate();
	        System.out.println(noofrows + " rows updated in the DB successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public void deleteEmployee(int empno) {
	    con = MyDbConnection.getMyConnection();
	    try {
	        ps = con.prepareStatement("DELETE FROM dedaemp WHERE empno = ?");
	        ps.setInt(1, empno);
	        int noofrows = ps.executeUpdate();
	        System.out.println(noofrows + " rows deleted from the DB successfully!");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}


}
