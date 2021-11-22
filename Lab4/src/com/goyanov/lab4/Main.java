package com.goyanov.lab4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Main
{
    public static void main(String[] args)
    {
        Pen[] pen = new Pen[10];
        pen[0] = new Pen("Ручка шариковая", "Erich Krause", Pen.Color.ЧЁРНЫЙ, false, 4.20);
        pen[1] = new Pen("Ручка автоматическая", "Fellowes", Pen.Color.ЗЕЛЁНЫЙ, true, 12.00);
        pen[2] = new Pen("Ручка PEN-2011", "Комус", Pen.Color.ЧЁРНЫЙ, true, 32.00);
        pen[3] = new Pen("Ручка красная", "BiC", Pen.Color.КРАСНЫЙ, false, 6.99);
        pen[4] = new Pen("Ручка синяя", "BiC", Pen.Color.СИНИЙ, false, 5.89);
        pen[5] = new Pen("Ручка-Крикучка", "Комус", Pen.Color.ЧЁРНЫЙ, true, 59.00);
        pen[6] = new Pen("Автоматическая ручка AU-20", "Auschan", Pen.Color.ЗЕЛЁНЫЙ, false, 45.00);
        pen[7] = new Pen("Ручка зелёная", "EI Casco", Pen.Color.ЗЕЛЁНЫЙ, false, 12.22);
        pen[8] = new Pen("Шариковая ручка", "Fellowes", Pen.Color.КРАСНЫЙ, true, 21.00);
        pen[9] = new Pen("Ручка PILOT", "Moleskine", Pen.Color.СИНИЙ, true, 13.20);

        JFrame frame = new JFrame("Таблица ручек");
        frame.setSize(850, 380);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Object[] headers = {"Название", "Производитель", "Цвет", "Автоматическая", "Цена, руб."};
        Object[][] content = new Object[10][];
        for (int i = 0; i < pen.length; i++)
        {
            content[i] = new Object[]{pen[i].getName(), pen[i].getFabricator(), pen[i].getColor(), pen[i].isAutomatic() ? "да" : "нет", pen[i].getCost()};
        }

        JTable table = new JTable(content, headers);
        table.setPreferredScrollableViewportSize(new Dimension(250,100));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.setVisible(true);
    }
}
