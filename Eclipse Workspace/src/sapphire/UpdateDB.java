package sapphire;
import java.sql.*;

import topaz.Student;
import topaz.payment;

public class UpdateDB
{
	public Connection con;
	PreparedStatement p1,p2;
	public UpdateDB()
	{
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:MyDb");
			p1=con.prepareStatement("update Student set ramount=? where sid=?");
			p2=con.prepareStatement("update Student set fname=?, pname=?, lname=?, address=?, contact=?, gender=?, school=?, class=?, doa=? where sid=?");
		}
		catch(Exception e){}
	}
	
	public void pay(payment pobj,int amt) throws Exception
	{
		p1.setInt(1,amt);
		p1.setInt(2,pobj.sid);
		p1.executeUpdate();	
		
	}
	public void allUp(Student sobj) throws Exception{
		p2.setString(1,sobj.fname);
		p2.setString(2,sobj.pname);
		p2.setString(3,sobj.lname);
		p2.setString(4,sobj.address);
		p2.setString(5,sobj.contact);
		p2.setInt(6,sobj.gender);
		p2.setInt(7,sobj.school);
		p2.setInt(8,sobj.std);
		p2.setDate(9,sobj.doa);
		p2.setInt(10,sobj.sid);
		p2.executeUpdate();
	}
	public void cClose() throws Exception{
		con.close();
	}
}