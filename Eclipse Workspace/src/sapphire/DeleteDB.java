package sapphire;
import java.sql.*;

import topaz.Student;
import topaz.payment;

@SuppressWarnings("unused")
public class DeleteDB{
	public Connection con;
	Student sobj;
	PreparedStatement p1,p2,p3,p4,p5;

	public DeleteDB(){
		try
		{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:MyDb");
			p1=con.prepareStatement("delete from student where sid=?");
			p2=con.prepareStatement("delete from payment where pid=?");
			p3=con.prepareStatement("delete from payment where sid=?");
			p4=con.prepareStatement("Delete from student");
			p5=con.prepareStatement("Delete from payment");
		}
		catch(Exception e){}
	}

	public void allDel() throws Exception 
	{
		p5.executeUpdate();
		p4.executeUpdate();
	}
	public void sDel(int sid) throws Exception
	{
		p1.setInt(1,sid);
		p1.executeUpdate();
	}

	public void spDel(int sid) throws Exception
	{
		p3.setInt(1,sid);
		p3.executeUpdate();
	}
	public void pDel(int pid) throws Exception
	{
		p2.setInt(1,pid);
		p2.executeUpdate();
	}
	public void cClose() throws Exception{
		con.close();
	}
}