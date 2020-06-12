package com.footballmanager.pl.events;

import com.footballmanager.dal.DataProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClickButtonActionListener implements ActionListener {
  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("Clicked");
  }
}
