package com.goyanov.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

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
            content[i] = new Object[]{pen[i].getName(), pen[i].getFabricator(), pen[i].getColor(), pen[i].isAutomatic() ? "да" : "нет", pen[i].getCost()};
        }

        JTable table = new JTable(content, headers);
        table.setPreferredScrollableViewportSize(new Dimension(250,80));
        JScrollPane scrollPane = new JScrollPane(table);

        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel functionalPanel = new JPanel();
        functionalPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 5));

        functionalPanel.add(new JTextField(13));
        functionalPanel.add(new JTextField(13));
        functionalPanel.add(new JTextField(13));
        functionalPanel.add(new Checkbox());
        functionalPanel.add(new JTextField(5));
        functionalPanel.add(new JButton("Добавить"));
        functionalPanel.add(new JButton("Очистить"));

        mainPanel.add(functionalPanel, BorderLayout.SOUTH);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
