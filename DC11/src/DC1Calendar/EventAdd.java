package DC1Calendar;

import java.util.*;
import java.text.*;

public class EventAdd extends javax.swing.JFrame
{
    private CalendarProgram origin;
    public EventAdd(CalendarProgram origin)
    {
    	this.origin = origin;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        monthBox = new javax.swing.JComboBox<>();
        dayBox = new javax.swing.JComboBox<>();
        yearBox = new javax.swing.JComboBox<>();
        holiEvent = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        colorBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        monthBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
        dayBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        yearBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031", "2032", "2033", "2034", "2035", "2036", "2037", "2038", "2039", "2040", "2041", "2042", "2043", "2044", "2045" }));
        yearBox.setSelectedIndex(26);
        holiEvent.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Event", "Holiday" }));
        jLabel1.setText("Month");
        jLabel2.setText("Day");
        jLabel3.setText("Year");
        jLabel4.setText("New Event");
        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jLabel5.setText("Color");
        colorBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "green", "blue", "red", "black", "pink", "yellow", "orange"}));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel1)
                .addGap(91, 91, 91)
                .addComponent(jLabel2)
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(holiEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(colorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addGap(14, 14, 14))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(11, 11, 11)))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monthBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dayBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yearBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(holiEvent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colorBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private String eventType;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
    {
        String[] eve=new String[5];
        eve[0]=monthBox.getSelectedItem().toString();
        eve[1]=dayBox.getSelectedItem().toString();
        eve[2]=yearBox.getSelectedItem().toString();
        eve[3]=jTextField1.getText();
        eve[4]=colorBox.getSelectedItem().toString();
        eventType=holiEvent.getSelectedItem().toString();

        DateFormat v = new SimpleDateFormat("mm/dd/yyyy");
        Date d = new Date();
        String[] sndate = v.format(d).split("[/]");
        GregorianCalendar cal = new GregorianCalendar(origin.getYearToday(), origin.getMonthToday(), 1);

        int nod = cal.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
        int som = cal.get(GregorianCalendar.DAY_OF_WEEK);

        new DataParser().writeCSVInfo(eve);
        int tyear = Integer.parseInt(eve[2].replaceAll("\\s", ""));
        int tmonth = Integer.parseInt(eve[0])-1;
        int tday = Integer.parseInt(eve[1]);

        if(eventType.equals("Holiday"))
        {
            if(origin.getYearToday() >= tyear)
            {
                if(origin.getMonthToday() == tmonth)
                {
                    System.out.println("Holiday: "+tyear+", "+tmonth+", "+tday);
                    System.out.println("Holiday Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    System.out.println(Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    if(tmonth == Integer.parseInt(sndate[0])-1 && tday == Integer.parseInt(sndate[1]) && origin.getYearToday() <= Integer.parseInt(sndate[2]))
                    {
                        ArrayList<String[]> temp = new ArrayList<>();
                        temp.add(eve);
                        origin.getModel().setNotification(temp, 0, tmonth, tday, origin.getYearToday());
                    }
                }
            }

            else if(origin.getYearToday() == tyear)
            {
                if(origin.getMonthToday() == tmonth)
                {
                    System.out.println("Holiday: "+tyear+", "+tmonth+", "+tday);
                    System.out.println("Holiday Parse: "+Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    System.out.println(Integer.parseInt(sndate[2])+", "+Integer.parseInt(sndate[0])+", "+Integer.parseInt(sndate[1]));
                    if(tmonth == Integer.parseInt(sndate[0])-1 && tday == Integer.parseInt(sndate[1]) && origin.getYearToday() == Integer.parseInt(sndate[2]))
                    {
                        ArrayList<String[]> temp = new ArrayList<>();
                        temp.add(eve);
                        origin.getModel().setNotification(temp, 0, tmonth, tday, origin.getYearToday());
                    }
                }
            }
        }
        origin.getModel().refreshCalendar(origin, origin.getMonthToday(), origin.getYearToday());
        this.dispose();
    }                                        

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        this.dispose();
    }                                        

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> colorBox;
    private javax.swing.JComboBox<String> dayBox;
    private javax.swing.JComboBox<String> holiEvent;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> monthBox;
    private javax.swing.JComboBox<String> yearBox;                 
}
