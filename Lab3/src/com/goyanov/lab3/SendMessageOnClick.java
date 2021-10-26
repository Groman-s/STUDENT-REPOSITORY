package com.goyanov.lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record SendMessageOnClick(String message) implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(message);
    }
}