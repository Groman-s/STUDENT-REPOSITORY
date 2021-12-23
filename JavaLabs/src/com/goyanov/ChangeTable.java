package com.goyanov;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class ChangeTable implements TableModelListener
{
    private ArrayList<Employer> employers;
    private JTable table;
    private TableModel tableModel;
    private DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    public ChangeTable() throws ParseException
    {
        JFrame frame = new JFrame("Сотрудники");
        JPanel panel = new JPanel();
        JPanel edit = new JPanel();

        panel.setLayout(new BorderLayout());
        panel.setLayout(new FlowLayout());

        JTextField surname = new JTextField(10);
        JTextField name = new JTextField(10);
        JTextField phone = new JTextField(10);
        JTextField stag = new JTextField(5);
        JTextField birth = new JTextField(7);
        JCheckBox isHigh = new JCheckBox();
        JButton add = new JButton("Добавить");
        JButton clear = new JButton("Очистить");

        add.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    employers.add(new Employer(surname.getText(), name.getText(), phone.getText(), Integer.parseInt(stag.getText()), formatter.parse(birth.getText()), isHigh.isSelected()));
                } catch (Exception ex)
                {
                    ex.printStackTrace();
                }

                ((AbstractTableModel)(tableModel)).fireTableDataChanged();
                table.updateUI();
            }
        });

        clear.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                surname.setText("");
                name.setText("");
                phone.setText("");
                stag.setText("");
                birth.setText("");
                isHigh.setSelected(false);
            }
        });

        frame.setLayout(new BorderLayout());
        frame.setSize(600,200);
        frame.setLocation(300,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Employer[] employs = new Employer[5];
        employs[0] = new Employer("Королёв", "Иван", "880000", 10, formatter.parse("25-12-1979"), Boolean.TRUE);
        employs[1] = new Employer("Королёв", "Иван", "180000", 22, formatter.parse("25-12-1979"), Boolean.TRUE);
        employs[2] = new Employer("Королёв", "Иван", "280000", 33, formatter.parse("25-12-1979"), Boolean.TRUE);
        employs[3] = new Employer("Королёв", "Иван", "380000", 44, formatter.parse("25-12-1979"), Boolean.TRUE);
        employs[4] = new Employer("Королёв", "Иван", "480000", 55, formatter.parse("25-12-1979"), Boolean.TRUE);

        employers = new ArrayList<>(Arrays.asList(employs));

        tableModel = new MyTableModel(employers);
        tableModel.addTableModelListener(this);
        table = new JTable(tableModel);
        table.setDefaultRenderer(Object.class, new Main.StringRenderer());
        table.setDefaultRenderer(Integer.class, new Main.IntRenderer());
        table.setDefaultRenderer(Boolean.class, new Main.BooleanRenderer());

        RowSorter<MyTableModel> sorter = new TableRowSorter<>((MyTableModel) tableModel);
        table.setRowSorter(sorter);

        JScrollPane scrollPane = new JScrollPane(table);
        table.setPreferredScrollableViewportSize(new Dimension(600,100));
        panel.add(scrollPane);

        edit.add(surname);
        edit.add(name);
        edit.add(phone);
        edit.add(stag);
        edit.add(birth);
        edit.add(isHigh);
        edit.add(add);
        edit.add(clear);

        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(edit, BorderLayout.SOUTH);

        frame.setVisible(true);
        frame.pack();
    }

    @Override
    public void tableChanged(TableModelEvent e)
    {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
    }
}
