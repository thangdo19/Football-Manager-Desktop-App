package com.footballmanager.pl.events;

import com.footballmanager.bll.PlayerManager;
import com.footballmanager.dal.DataProvider;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

public class ClickButtonActionListener implements ActionListener {
  private JList list;

  public ClickButtonActionListener(JList list) {
    this.list = list;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    CompletableFuture
      .runAsync(() -> new PlayerManager().addPlayer())
      .thenRunAsync(() -> list.setListData(new PlayerManager().getPlayers().toArray()))
      .thenRunAsync(() -> JOptionPane.showMessageDialog(null, "Done"));
    System.out.println("Clicked");
  }
}
