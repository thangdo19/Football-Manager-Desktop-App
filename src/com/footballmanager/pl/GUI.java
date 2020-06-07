package com.footballmanager.pl;

import com.footballmanager.bll.PlayerGetter;
import com.footballmanager.bll.PlayerManager;
import com.footballmanager.pl.events.ClickButtonActionListener;
import com.footballmanager.pl.events.ShowButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public class GUI {
  private PlayerGetter playerGetter;

  public GUI(PlayerGetter playerGetter) {
    this.playerGetter = playerGetter;
  }

  public void createGUI() {
    JFrame frame = createFrame("Football Manager");
    createComponents(frame.getContentPane());
    frame.setVisible(true);
  }

  private JFrame createFrame(String title) {
    JFrame frame = new JFrame(title);

    frame.setSize(300, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);

    return frame;
  }

  private void createComponents(Container container) {
    JPanel panel = new JPanel(new BorderLayout());
    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    JList list;
    JButton buttonShow = new JButton("Show");
    JButton buttonClick = new JButton("Click");

    list = new JList(playerGetter.getPlayers().toArray());
    var scrollPane = new JScrollPane(list);
    panel.add(scrollPane, BorderLayout.CENTER);

    buttonShow.addActionListener(new ShowButtonActionListener(list));
    buttonClick.addActionListener(new ClickButtonActionListener());
    panel.add(buttonShow, BorderLayout.SOUTH);
//    panel.add(centerPanel, BorderLayout.CENTER);
//    panel.add(table, BorderLayout.NORTH);
//    panel.add(buttonClick, BorderLayout.NORTH);
    container.add(panel);
  }

  private Object[][] takePlayersIn2DArray() {
    var listPlayers = new PlayerManager().getPlayers()
      .stream()
      .map(player -> List.of(player.getShirtNo(), player.getName(), player.getClubName()).toArray())
      .collect(Collectors.toList());

    var array = new Object[listPlayers.size()][];
    for (int i = 0; i < listPlayers.size(); i++) {
      Object[] row = listPlayers.get(i);
      array[i] = row;
    }
    return array;
  }
}