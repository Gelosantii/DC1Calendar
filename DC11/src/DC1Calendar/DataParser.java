package DC1Calendar;

import java.io.*;
import java.util.ArrayList;

public class DataParser
{
    public DataParser()
    {
        getCSVData();
        getPSVData();
        printEvents();
        printHolidays();
    }
    
    private ArrayList<String[]> events = new ArrayList<String[]>();
    private ArrayList<String[]> holidays = new ArrayList<String[]>();
    private File file;
    private BufferedReader reader = null;
    
    public void writeCSVInfo(String[] event)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("Philippine Holidays.csv"), true));
            StringBuilder sb = new StringBuilder();		
            pw.println("");
            sb.append(event[0]);
            sb.append('/');
            sb.append(event[1]);
            sb.append('/');
            sb.append(event[2]);
            sb.append(',');
            sb.append(' ');
            sb.append(event[3]);
            sb.append(',');
            sb.append(' ');
            sb.append(event[4]);
            pw.append(sb.toString());
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println("Failed to write data");
        }
    }
    public void writePSVInfo(String[] event)
    {
        try
        {
            PrintWriter pw = new PrintWriter(new FileOutputStream(new File("DLSU Unicalendar.psv"), true));
            StringBuilder sb = new StringBuilder();
            pw.println("");
            sb.append(event[3]);
            sb.append(' ');
            sb.append('|');
            sb.append(' ');
            sb.append(event[0]);
            sb.append('/');
            sb.append(event[1]);
            sb.append('/');
            sb.append(event[2]);
            sb.append(' ');
            sb.append('|');
            sb.append(' ');
            sb.append(event[4]);		
            pw.append(sb.toString());
            pw.close();
        }
        catch(Exception e)
        {
            System.out.println("Failed to write data");
        }
    }
    private void getCSVData()
    {
        try
        {
            file = new File("Philippine Holidays.csv");
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String temp[] = line.split("[/,]");
                for(int i = 0;i < temp.length; i++)
                {
                    if((temp[i]).charAt(0) == ' ')
                    {
                        StringBuilder sb = new StringBuilder(temp[i]);
                        sb.deleteCharAt(0);
                        temp[i] = sb.toString();
                    }	
                }
                holidays.add(temp);
            }	
            reader.close();
            file = null;
        }
        catch(Exception e)
        {
            System.out.println("Failed to load csv events");
        }
    }
    private void getPSVData()
    {
        try
        {
            file = new File("DLSU Unicalendar.psv");
            reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null)
            {
                String temp[] = line.split("[/|,]");
                String tempE = temp[0];
                for(int i = 0; i<3; i++)
                    temp[i] = temp[i+1];
                temp[3] = tempE;
                for(int i = 0; i < temp.length; i++)
                {
                    if((temp[i]).charAt(0) == ' ')
                    {
                        StringBuilder sb = new StringBuilder(temp[i]);
                        sb.deleteCharAt(0);
                        temp[i] = sb.toString();
                    }	
                }
            events.add(temp);
            }	
            reader.close();
            file = null;
        }
        catch(Exception e)
        {
            System.out.println("Failed to load psv events");
        }
    }
    private void printEvents()
    {
        for(int i = 0; i < events.size(); i++)
        {
            for(int j = 0; j < events.get(i).length; j++)
                System.out.println(events.get(i)[j]);
            System.out.println("--------------------");
        }
    }
    private void printHolidays()
    {
        for(int i = 0; i < holidays.size(); i++)
        {
            for(int j = 0; j < holidays.get(i).length; j++)
                System.out.println(holidays.get(i)[j]);
            System.out.println("--------------------");
        }
    }
    public ArrayList<String[]> getEvents()
    {
        return events;
    }
    public ArrayList<String[]> getHolidays()
    {
        return holidays;
    }
}
