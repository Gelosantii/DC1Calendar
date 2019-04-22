package DC1Calendar;

import java.util.*;
import java.text.*;
import javax.swing.JFrame;
import java.awt.Color;
import facebook.FBView;
import sms.*;

public class CalendarModel
{
    private SMSView sm;
    private FBView fb;
    private SMS s;
    private DateFormat v = new SimpleDateFormat("mm/dd/yyyy");
    private Date d = new Date();
    private String[] sndate= v.format(d).split("[/]");
    public CalendarModel()
    {
        fb = new FBView();
        fb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        sm = new SMSView();
        sm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void refreshCalendar(CalendarProgram program, int month, int year)
    {
        ArrayList<String[]> events = new ArrayList<String[]>();
        ArrayList<String[]> holidays = new ArrayList<String[]>();
        DataParser f = new DataParser();
        
        events = f.getEvents();
        holidays = f.getHolidays();
        
        String[] months =  { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" };
        int nod, som, i, j;

        program.getBtnPrev().setEnabled(true);
        program.getBtnNext().setEnabled(true);
        
        if (month == 0 && year <= program.getYearBound()-10)
            program.getBtnPrev().setEnabled(false);
        if (month == 11 && year >= program.getYearBound()+100)
            program.getBtnNext().setEnabled(false);

        program.getMonthLabel().setText(months[month]);
        program.getMonthLabel().setBounds(320-program.getMonthLabel().getPreferredSize().width/2, 50, 360, 50);

        for (i = 0; i < 6; i++)
            for (j = 0; j < 7; j++)
                program.getModelCalendarTable().setValueAt(null, i, j);

        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);

		
        int row = 0;
        int column = 0;
        for (i = 1; i <= nod; i++)
        {
            row = new Integer((i+som-2)/7);
            column  =  (i+som-2)%7;
            program.getModelCalendarTable().setValueAt( i, row, column);
        }

        for(i = 0; i < events.size(); i++)
        {
            int tyear = Integer.parseInt(events.get(i)[2].replaceAll("\\s", ""));
            int tmonth = Integer.parseInt(events.get(i)[0])-1;
            int tday = Integer.parseInt(events.get(i)[1]);
            if(year == tyear)
                if(month == tmonth)
                {
                    System.out.println("Event: "+tyear+", "+tmonth+", "+tday);
                    System.out.println("Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    int dayr=new Integer((tday+som-2)/7);
                    int dayc=(tday+som-2)%7;
                    program.getModelCalendarTable().setValueAt(String.format("<html>%s<br>  <font size=\"-2\"><font color='%s'> %s", program.getModelCalendarTable().getValueAt(dayr, dayc).toString(),events.get(i)[4], events.get(i)[3]), dayr, dayc);
                }
        }
        removeTag(events, program, year, month);
        for(i=0; i<holidays.size();i++)
        {
            int tyear=Integer.parseInt(holidays.get(i)[2].replaceAll("\\s", ""));
            int tmonth=Integer.parseInt(holidays.get(i)[0])-1;
            int tday=Integer.parseInt(holidays.get(i)[1]);
            if(year >= tyear)
                if(month == tmonth)
                {
                    System.out.println("Holiday: "+tyear+", "+tmonth+", "+tday);
                    System.out.println("Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    int dayr=new Integer((tday+som-2)/7);
                    int dayc=(tday+som-2)%7;
                    program.getModelCalendarTable().setValueAt(String.format("<html>%s<br>  <font size=\"-2\"><font color='%s'> %s", program.getModelCalendarTable().getValueAt(dayr, dayc).toString(),holidays.get(i)[4], holidays.get(i)[3]), dayr, dayc);
                }
        }
        removeTag(holidays, program, year, month);	
        program.getCalendarTable().setDefaultRenderer(program.getCalendarTable().getColumnClass(0), new TableRenderer());
    }
	
    public void removeTag(ArrayList<String[]> array, CalendarProgram program, int year, int month)
    {
        GregorianCalendar cal = new GregorianCalendar(year, month, 1);
        int som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        for(int i=0; i<array.size();i++) {
            int tyear=Integer.parseInt(array.get(i)[2].replaceAll("\\s", ""));
            int tmonth=Integer.parseInt(array.get(i)[0])-1;
            int tday=Integer.parseInt(array.get(i)[1]);
            if(year >= tyear)
                if(month == tmonth)
                {
                    System.out.println(tyear+", "+tmonth+", "+tday);
                    int dayr=new Integer((tday+som-2)/7);
                    int dayc=(tday+som-2)%7;
                    String s = program.getModelCalendarTable().getValueAt(dayr, dayc).toString();
                    program.getModelCalendarTable().setValueAt((s.replace("<html><html>", "<html>")), dayr, dayc);
                }
        }
    }

    public void setNotification(ArrayList<String[]> array, int i, int tmonth, int tday, int year)
    {
        GregorianCalendar cal = new GregorianCalendar(year, tmonth, 1);

        cal.set(year, tmonth, tday);
        if(array.get(i)[4].equals("green"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.green);
            s = new SMS(array.get(i)[3], cal, Color.green);
        }
        else if(array.get(i)[4].equals("blue"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.blue);
            s = new SMS(array.get(i)[3], cal, Color.blue);
        }
        else if(array.get(i)[4].equals("red"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.red);
            s = new SMS(array.get(i)[3], cal, Color.red);
        }
        else if(array.get(i)[4].equals("black"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.black);
            s = new SMS(array.get(i)[3], cal, Color.black);
        }					
        else if(array.get(i)[4].equals("pink"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.pink);
            s = new SMS(array.get(i)[3], cal, Color.pink);
        }
        else if(array.get(i)[4].equals("yellow"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.yellow);
            s = new SMS(array.get(i)[3], cal, Color.yellow);
        }
        else if(array.get(i)[4].equals("orange"))
        {
            fb.showNewEvent(array.get(i)[3], tmonth+1, tday, year, Color.orange);
            s = new SMS(array.get(i)[3], cal, Color.orange);
        }
        sm.sendSMS(s);
    }
}
