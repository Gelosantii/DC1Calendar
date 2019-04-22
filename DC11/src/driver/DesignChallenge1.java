package driver;
import DC1Calendar.*;

public class DesignChallenge1
{
    public static void main(String[] args)
    {
    	CalendarView view = new CalendarView();
    	CalendarModel model = new CalendarModel();
        CalendarProgram cp = new CalendarProgram(view, model);
        cp.run();
    }
}
