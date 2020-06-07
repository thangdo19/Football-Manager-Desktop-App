package com.footballmanager.pl.events;

import com.footballmanager.bll.PlayerManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.CompletableFuture;

public class ShowButtonActionListener implements ActionListener {
  private JList list;

  public ShowButtonActionListener(JList list) {
    this.list = list;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    var takingPlayers = CompletableFuture
      .runAsync(() -> list.setListData(new PlayerManager().getPlayers().toArray()))
      .thenRun(() -> JOptionPane.showMessageDialog(null, "Done"));
  }
}