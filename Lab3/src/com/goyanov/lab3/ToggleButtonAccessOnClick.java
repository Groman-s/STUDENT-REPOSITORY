package com.goyanov.lab3;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public record ToggleButtonAccessOnClick(JButton button) implements ActionListener
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        button.setEnabled(!button.isEnabled());
    }
}
