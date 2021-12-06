package com.goyanov;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel
{
    private ArrayList<Employer> employers;

    public MyTableModel(ArrayList<Employer> pen)
    {
        super();
        this.employers = pen;
    }

    @Override
    public int getRowCount()
    {
        return employers.size();
    }

    @Override
    public int getColumnCount()
    {
        return 6;
    }

    @Override
    public String getColumnName(int column)
    {
        switch (column)
        {
            case 0: return "Фамилия";
            case 1: return "Имя";
            case 2: return "Телефон";
            case 3: return "Стаж";
            case 4: return "Дата рождения";
            case 5: return "Высшее образование";
            default: return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        switch (columnIndex)
        {
            case 0: return employers.get(rowIndex).getSurname();
            case 1: return employers.get(rowIndex).getName();
            case 2: return employers.get(rowIndex).getPhone();
            case 3: return employers.get(rowIndex).getStag();
            case 4: return formatter.format(employers.get(rowIndex).getBirth());
            case 5: return employers.get(rowIndex).getHigh();
            default: return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return getValueAt(0, columnIndex).getClass();
    }
}
