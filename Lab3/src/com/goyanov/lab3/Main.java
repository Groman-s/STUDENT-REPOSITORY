package com.goyanov.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Моя супер лаба");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(340,120);

        JButton btn1 = new JButton("Привет");
        btn1.addActionListener(new SendMessageOnClick(btn1.getText()));

        JCheckBox checkBox1 = new JCheckBox();
        checkBox1.setSelected(true);
        checkBox1.setHorizontalAlignment(0);
        checkBox1.addActionListener(new ToggleButtonAccessOnClick(btn1));

        JButton btn2 = new JButton("Как дела?");
        btn2.addActionListener(new SendMessageOnClick(btn2.getText()));

        JCheckBox checkBox2 = new JCheckBox();
        checkBox2.setSelected(true);
        checkBox2.setHorizontalAlignment(0);
        checkBox2.addActionListener(new ToggleButtonAccessOnClick(btn2));

        JButton btn3 = new JButton("Что делаешь?");
        btn3.addActionListener(new SendMessageOnClick(btn3.getText()));

        JCheckBox checkBox3 = new JCheckBox();
        checkBox3.setSelected(true);
        checkBox3.setHorizontalAlignment(0);
        checkBox3.addActionListener(new ToggleButtonAccessOnClick(btn3));

        GridLayout layout = new GridLayout(3,2);

        frame.setLayout(layout);

        frame.add(btn1);
        frame.add(checkBox1);
        frame.add(btn2);
        frame.add(checkBox2);
        frame.add(btn3);
        frame.add(checkBox3);

        frame.setVisible(true);
    }
}
