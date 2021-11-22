package com.goyanov.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.util.Arrays;

public class Main
{
    public static void main(String[] args)
    {
        Pen[] pen = new Pen[10];
        pen[0] = new Pen("Ручка шариковая", "Erich Krause", Pen.Color.ЧЁРНЫЙ, false, 4.22);
        pen[1] = new Pen("Ручка автоматическая", "Fellowes", Pen.Color.ЗЕЛЁНЫЙ, true, 12.23);
        pen[2] = new Pen("Ручка PEN-2011", "Комус", Pen.Color.ЧЁРНЫЙ, true, 32.13);
        pen[3] = new Pen("Ручка красная", "BiC", Pen.Color.КРАСНЫЙ, false, 6.99);
        pen[4] = new Pen("Ручка синяя", "BiC", Pen.Color.СИНИЙ, false, 5.89);
        pen[5] = new Pen("Ручка-Крикучка", "Комус", Pen.Color.ЧЁРНЫЙ, true, 59.99);
        pen[6] = new Pen("Автоматическая ручка AU-20", "Auschan", Pen.Color.ЗЕЛЁНЫЙ, false, 45.99);
        pen[7] = new Pen("Ручка зелёная", "EI Casco", Pen.Color.ЗЕЛЁНЫЙ, false, 12.22);
        pen[8] = new Pen("Шариковая ручка", "Fellowes", Pen.Color.КРАСНЫЙ, true, 21.89);
        pen[9] = new Pen("Ручка PILOT", "Moleskine", Pen.Color.СИНИЙ, true, 13.22);

        JFrame frame = new JFrame("Таблица ручек");
        frame.setSize(870, 280);
        frame.setResizable(true);// TODO false
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        Object[] headers = {"Название", "Производитель", "Цвет", "Автоматическая", "Цена, руб."};
        Object[][] content = new Object[10][];
        for (int i = 0; i < pen.length; i++)
        {
            content[i] = new Object[]{pen[i].getName(), pen[i].getFabricator(), pen[i].getColor(), pen[i].isAutomatic(), pen[i].getCost()};
        }

        DefaultTableModel model = new DefaultTableModel(content, headers)
        {
            @Override
            public Class<?> getColumnClass(int columnIndex)
            {
                return getValueAt(0, columnIndex).getClass();
            }

            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };
        JTable table = new JTable(model);
        RowSorter<TableModel> sorter = new TableRowSorter<>(model);
        table.setRowSorter(sorter);
        table.setPreferredScrollableViewportSize(new Dimension(250,80));
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel functionalPanel = new JPanel();
        functionalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        JTextField name = new JTextField(13);
        functionalPanel.add(name);

        JTextField fabricator = new JTextField(13);
        functionalPanel.add(fabricator);

        JTextField color = new JTextField(13);
        functionalPanel.add(color);

        JCheckBox automatic = new JCheckBox();
        functionalPanel.add(automatic);

        JTextField cost = new JTextField(5);
        functionalPanel.add(cost);

        JButton addButton = new JButton("Добавить");
        addButton.addActionListener((event)->
        {
            try {
                model.addRow(new Object[]{name.getText(), fabricator.getText(), Pen.Color.valueOf(color.getText().toUpperCase()), automatic.isSelected(), Double.parseDouble(cost.getText())});
            } catch (Exception e) { System.out.println("Ошибка в переданных аргументах. Проверьте данные."); }
        });
        functionalPanel.add(addButton);

        JButton clearButton = new JButton("Очистить");
        clearButton.addActionListener((event) ->
        {
            Arrays.stream(functionalPanel.getComponents()).filter(e -> e instanceof JTextField).map(JTextField.class::cast).forEach(e -> e.setText(""));
            automatic.setSelected(false);
        });
        functionalPanel.add(clearButton);

        mainPanel.add(functionalPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
