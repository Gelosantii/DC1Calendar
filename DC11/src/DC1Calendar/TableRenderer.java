package DC1Calendar;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRenderer extends DefaultTableCellRenderer
{
    public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column)
    {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        
        if (column == 0 || column == 6)
            setBackground(new Color(195,239,194));
        else
            setBackground(new Color(240,250,239));
        
        setBorder(null);
        setForeground(Color.black);
        
        return this;  
    }
}
