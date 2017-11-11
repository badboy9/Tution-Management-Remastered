package sapphire;
import java.sql.*;
import topaz.Student;
import topaz.payment;

public class InsertDB{
	public  Connection con;
	PreparedStatement ptas,ptap,pt1;
	public InsertDB(){
		try{
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			con=DriverManager.getConnection("jdbc:odbc:MyDb");
			ptas=con.prepareStatement("Insert into student values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ptap=con.prepareStatement("Insert into payment values(?,?,?,?)");
			pt1=con.prepareStatement("Insert into student(pamount) values(?)");
		}
		catch(Exception e){System.out.println(""+e);}
	}
	public void sAdd(Student obj) throws Exception{

		ptas.setInt(1,obj.sid);
		ptas.setString(2,obj.fname);
		ptas.setString(3,obj.pname);
		ptas.setString(4,obj.lname);
		ptas.setString(5,obj.address);
		ptas.setString(6,obj.contact);
		ptas.setInt(7,obj.gender);
		ptas.setInt(8,obj.school);
		ptas.setInt(9,obj.std);
		ptas.setInt(10,obj.subject);
		ptas.setDate(11,obj.doa);
		ptas.setInt(12,obj.months);
		ptas.setInt(13,obj.ramount);
		ptas.executeUpdate();
	}
	public void pAdd(payment pobj) throws Exception
	{
		ptap.setInt(1,pobj.pid);
		ptap.setInt(2,pobj.sid);
		ptap.setInt(3,pobj.pamount);
		ptap.setDate(4,pobj.dop);
		ptap.executeUpdate();
	}
	public void pAmt(int amt)throws Exception
	{
		System.out.println("Hello");
		pt1.setInt(1,amt);
	}
	public void cClose() throws Exception{
		con.close();
	}
}