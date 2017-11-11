package sapphire;
import java.sql.*;

import topaz.Student;
import topaz.payment;

public class ExtractDB{
	public Connection con;
	PreparedStatement p0,p1,p2,p3,p4,p5,p6,p7,p8,p9;
	public ExtractDB(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:MyDb");
			p0=con.prepareStatement("select * from Student where sid=?");
			p1=con.prepareStatement("select fname,lname from Student where sid=?");	
			p2=con.prepareStatement("select * from student where class=?");
			p3=con.prepareStatement("select * from student where school=?");
			p4=con.prepareStatement("select * from student where ramount>?");
			p5=con.prepareStatement("select * from payment where pid=?");
			p6=con.prepareStatement("select * from student where fname=?");
			p7=con.prepareStatement("select payment.pid, payment.sid, student.fname, student.lname, payment.pamount, payment.dop from payment,student where payment.sid=student.sid AND payment.sid=?");
			p8=con.prepareStatement("select payment.pid, payment.sid, student.fname, student.lname, payment.pamount, payment.dop from payment,student where payment.sid=student.sid AND payment.pid=?");
			p9=con.prepareStatement("select ramount from Student where sid=?");
		}
		catch(Exception e){}
	}
	public void objExtract(payment pobj,int pid) throws Exception{
		p5.setInt(1,pid);
		ResultSet rs=p5.executeQuery();
		rs.next();
		pobj.pid=rs.getInt(1);
		pobj.sid=rs.getInt(2);
		pobj.pamount=rs.getInt(3);
		
	}
	public ResultSet sidExtract(Student sobj) throws Exception{
		p0.setInt(1,sobj.sid);
		return p0.executeQuery();
		
	}
	public ResultSet fnmExtract(Student sobj) throws Exception
	{
		p6.setString(1,sobj.fname);
		return p6.executeQuery();
	}
	public ResultSet classExtract(Student sobj) throws Exception
	{
		p2.setInt(1,sobj.std);
		return p2.executeQuery();
	}
	public ResultSet schoolExtract(Student sobj) throws Exception
	{
		p3.setInt(1,sobj.school);
		return p3.executeQuery();
	}
	public ResultSet ramountExtract(Student sobj) throws Exception
	{
		p4.setInt(1,sobj.ramount);
		return p4.executeQuery();
	}
	public String nmExtract(int id) throws Exception{
		p1.setInt(1,id);
		ResultSet rs=p1.executeQuery();
		rs.next();
		String str=rs.getString(1)+" "+rs.getString(2);
		return str;
	}
	public int amtExtract(int id) throws Exception{
		p9.setInt(1,id);
		ResultSet rs=p9.executeQuery();
		rs.next();
		int amt=rs.getInt(1);
		return amt;
	}
	public ResultSet sidExtract(payment pobj) throws Exception{
		p7.setInt(1,pobj.sid);
		return p7.executeQuery();
	}
	public ResultSet pidExtract(payment pobj) throws Exception{
		p8.setInt(1,pobj.pid);
		return p8.executeQuery();
	}

	public void cClose() throws Exception{
		con.close();
	}
}