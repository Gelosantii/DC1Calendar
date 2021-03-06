package DC1Calendar;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.text.*;
import java.util.*;

public class CalendarProgram
{
    private CalendarView view;
    private CalendarModel model;

    /**** Day Components ****/
    private int yearBound, monthBound, dayBound, yearToday, monthToday;

    /**** Swing Components ****/
    private JLabel monthLabel, yearLabel;
    private JButton btnPrev, btnNext, btnwrite;
    private JComboBox cmbYear;
    private JFrame frmMain;
    private Container pane;
    private JScrollPane scrollCalendarTable;
    private JPanel calendarPanel;

    /**** Calendar Table Components ***/
    private JTable calendarTable;
    private DefaultTableModel modelCalendarTable;

    public CalendarProgram(CalendarView view, CalendarModel model){
            this.view = view;
            this.model = model;
    }

    public void run()
    {
            view = new CalendarView(this);
            model.refreshCalendar(this, monthBound, yearBound);
            initNotification();
    }

    public void initNotification()
    {
        int i, dow, dom;
        ArrayList<String[]> events = new ArrayList<String[]>();
        ArrayList<String[]> holidays = new ArrayList<String[]>();
        DataParser f = new DataParser();
        events = f.getEvents();
        holidays = f.getHolidays();
        DateFormat v = new SimpleDateFormat("mm/dd/yyyy");
        Date d = new Date();
        String[] sndate= v.format(d).split("[/]");
        GregorianCalendar cal = new GregorianCalendar(yearToday, monthToday, 1);
        dom = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        dow = cal.get(GregorianCalendar.DAY_OF_WEEK);
        for(i=0; i<events.size();i++)
        {
            int tyear=Integer.parseInt(events.get(i)[2].replaceAll("\\s", ""));
            int tmonth=Integer.parseInt(events.get(i)[0])-1;
            int tday=Integer.parseInt(events.get(i)[1]);
            if(yearToday == tyear)
                if(monthToday == tmonth)
                {
                    System.out.println("Event: "+tyear+", "+tmonth+", "+tday);
                    System.out.println("Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    if(tmonth == Integer.parseInt(sndate[0])-1 && tday == Integer.parseInt(sndate[1]) && yearToday == Integer.parseInt(sndate[2])) 
                        model.setNotification(events, i, tmonth, tday, tyear);
                }
        }
        model.removeTag(events, this, yearToday, monthToday);
        for(i=0; i<holidays.size();i++)
        {
                int tyear=Integer.parseInt(holidays.get(i)[2].replaceAll("\\s", ""));
                int tmonth=Integer.parseInt(holidays.get(i)[0])-1;
                int tday=Integer.parseInt(holidays.get(i)[1]);
                if(yearToday >= tyear)
                    if(monthToday == tmonth)
                    {
                        System.out.println("Holiday: "+tyear+", "+tmonth+", "+tday);
                        System.out.println("Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                        if(tmonth == Integer.parseInt(sndate[0])-1 && tday == Integer.parseInt(sndate[1]) && yearToday <= Integer.parseInt(sndate[2]))
                        {
                            model.setNotification(holidays, i, tmonth, tday, yearToday);
                        }
                    }
        }
        model.removeTag(holidays, this, yearToday, monthToday);
    }		

    public int getYearBound()
    {
            return yearBound;
    }
    
    public void setYearBound(int yearBound)
    {
            this.yearBound = yearBound;
    }
    
    public int getMonthBound()
    {
            return monthBound;
    }
    
    public void setMonthBound(int monthBound)
    {
            this.monthBound = monthBound;
    }
    
    public int getDayBound()
    {
            return dayBound;
    }
    
    public void setDayBound(int dayBound)
    {
            this.dayBound = dayBound;
    }
    
    public int getYearToday()
    {
            return yearToday;
    }
    
    public void setYearToday(int yearToday)
    {
            this.yearToday = yearToday;
    }
    
    public int getMonthToday()
    {
            return monthToday;
    }
    
    public void setMonthToday(int monthToday)
    {
            this.monthToday = monthToday;
    }
    
    public JLabel getMonthLabel()
    {
            return monthLabel;
    }
    
    public void setMonthLabel(JLabel monthLabel)
    {
            this.monthLabel = monthLabel;
    }
    
    public JLabel getYearLabel()
    {
            return yearLabel;
    }
    
    public void setYearLabel(JLabel yearLabel)
    {
            this.yearLabel = yearLabel;
    }
    
    public JButton getBtnPrev()
    {
            return btnPrev;
    }
    
    public void setBtnPrev(JButton btnPrev)
    {
            this.btnPrev = btnPrev;
    }
    
    public JButton getBtnNext()
    {
            return btnNext;
    }
    
    public void setBtnNext(JButton btnNext)
    {
            this.btnNext = btnNext;
    }
    
    public JButton getBtnwrite()
    {
            return btnwrite;
    }
    
    public void setBtnwrite(JButton btnwrite)
    {
            this.btnwrite = btnwrite;
    }
    
    public JComboBox getCmbYear()
    {
            return cmbYear;
    }
    
    public void setCmbYear(JComboBox cmbYear)
    {
            this.cmbYear = cmbYear;
    }
    
    public JFrame getFrmMain()
    {
            return frmMain;
    }
    
    public void setFrmMain(JFrame frmMain)
    {
            this.frmMain = frmMain;
    }
    
    public Container getPane()
    {
            return pane;
    }
    
    public void setPane(Container pane)
    {
            this.pane = pane;
    }
    
    public JScrollPane getScrollCalendarTable()
    {
            return scrollCalendarTable;
    }
    
    public void setScrollCalendarTable(JScrollPane scrollCalendarTable)
    {
            this.scrollCalendarTable = scrollCalendarTable;
    }
    
    public JPanel getCalendarPanel()
    {
            return calendarPanel;
    }
    
    public void setCalendarPanel(JPanel calendarPanel)
    {
            this.calendarPanel = calendarPanel;
    }
    
    public EventAdd getEvents()
    {
            return new EventAdd(this);
    }
    
    public JTable getCalendarTable()
    {
            return calendarTable;
    }
    
    public void setCalendarTable(JTable calendarTable)
    {
            this.calendarTable = calendarTable;
    }
    
    public DefaultTableModel getModelCalendarTable()
    {
            return modelCalendarTable;
    }
    
    public void setModelCalendarTable(DefaultTableModel modelCalendarTable)
    {
            this.modelCalendarTable = modelCalendarTable;
    }
    
    public CalendarView getView()
    {
            return view;
    }
    
    public void setView(CalendarView view)
    {
            this.view = view;
    }
    
    public CalendarModel getModel()
    {
            return model;
    }
    
    public void setModel(CalendarModel model)
    {
            this.model = model;
    }
}