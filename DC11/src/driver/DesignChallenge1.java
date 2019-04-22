package driver;
import DC1Calendar.*;

public class DesignChallenge1
{
    public static void main(String[] args)
    {
    	calendarView view = new calendarView();
    	calendarModel model = new calendarModel();
        CalendarProgram cp = new CalendarProgram(view, model);
        cp.run();
    }
}
