package com.goyanov.lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main
{
    public static void createGroup(JFrame frameToAdd, String buttonName)
    {
        JButton button = new JButton(buttonName);
        button.addActionListener((event) -> System.out.println(button.getText()));

        JCheckBox checkBox = new JCheckBox();
        checkBox.setSelected(true);
        checkBox.setHorizontalAlignment(0);
        checkBox.addActionListener((event) -> button.setEnabled(!button.isEnabled()));

        frameToAdd.add(button);
        frameToAdd.add(checkBox);
    }

    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Моя супер лаба");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(340,120);
        frame.setLayout(new GridLayout(3,2));

        createGroup(frame, "Привет");
        createGroup(frame, "Как дела?");
        createGroup(frame, "Что делаешь?");

        frame.setVisible(true);
    }
}
