package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class EmpAccess 
{
	Connection conn=null;
	 Statement stm = null;
	 ResultSet rs=null;
	 
	 
	public EmpBean getSalary(String name) throws ClassNotFoundException, SQLException{
	 
	 String dbURL = "jdbc:mysql://localhost:3306/emp" ;
	 String username = "root";
	 String password = "";
	 EmpBean empbean=new EmpBean();
	 Class.forName("com.mysql.jdbc.Driver");
		conn= DriverManager.getConnection(dbURL, username, password);
		stm=conn.createStatement();
	String sql="Select Salary from employeetb where EmpName='"+name+"'";
	rs=stm.executeQuery(sql);
	int sal=0;
	while(rs.next())
	{
		 sal=rs.getInt("Salary");
		 System.out.println(sal);
	}
	empbean.setSalary(sal);
		return empbean;
	}
}
