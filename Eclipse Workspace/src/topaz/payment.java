package topaz;
import java.sql.Date;
import java.util.Calendar;

public class payment {
public int pid,sid,pamount;
public Date dop;
	public payment()
	{
		pid=sid=pamount=0;
		dop=new Date(Calendar.getInstance().getTimeInMillis());
	}
}
