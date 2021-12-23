package com.goyanov;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;

public class Main
{
    static class DateRenderer extends DefaultTableCellRenderer
    {
        DateFormat format = DateFormat.getDateInstance();

        public void setValue(Object value)
        {
            if (format == null) format = DateFormat.getDateInstance();
            setText(value == null ? "" : format.format(value));
        }
    }

    static class StringRenderer implements TableCellRenderer
    {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            JTextField editor = new JTextField();
            if (value != null) editor.setText(value.toString());
            editor.setBackground(row % 2 == 0 ? Color.WHITE : Color.CYAN);
            return editor;
        }
    }

    static class IntRenderer extends DefaultTableCellRenderer
    {
        public IntRenderer()
        {
            setHorizontalAlignment(SwingConstants.RIGHT);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            if (value == null) return this;
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            renderer.setBackground((Integer) value < 10 ? Color.YELLOW : Color.CYAN);
            return renderer;
        }
    }

    static class BooleanRenderer extends DefaultTableCellRenderer
    {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
        {
            JCheckBox editor = new JCheckBox();
            Boolean b = ((Boolean) value);
            editor.setBackground(b ? Color.GREEN : Color.WHITE);
            editor.setSelected(b);
            editor.setHorizontalAlignment(0);
            return editor;
        }
    }

    /// для текстовых полей чётные строки бирюзовым
    /// для числовых величин значения меньше 10 жёлтые, остальные бирюзовые (выравнивание по правой границе)
    /// для логических величин true зелёные, иначе белые

    public static void main(String[] args) throws ParseException
    {
        new ChangeTable();
    }
}
