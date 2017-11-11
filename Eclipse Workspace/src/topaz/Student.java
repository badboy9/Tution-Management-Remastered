package topaz;
import java.sql.Date;
import java.util.Calendar;

public class Student {
public int sid;
public Date doa;	
public String fname,pname,lname,address,contact;
public int gender,school,std,subject,months,ramount;
	public Student()
	{
		sid=0;
		fname=pname=lname=address=contact="";
		doa=new Date(Calendar.getInstance().getTimeInMillis());
		gender=school=std=subject=months=ramount=0;
	}
}
