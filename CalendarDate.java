import java.util.Calendar;
import java.util.Date;


public class CalendarDate {
	Calendar cal;
	public Date date;
	
	public CalendarDate(Date d) {
		date = d;
		cal = Calendar.getInstance();
		cal.setTime(d);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
	};
	
	Calendar getCalendarDate() {
		return cal;
	}
	
}
