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
  private MainBorderLayoutPanel panel;
  private JPanel centerPanel;
  private JList list;
  private JScrollPane scrollPane;
  private JButton buttonShow;
  private JButton buttonClick;

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
    frame.setLocationRelativeTo(null); // set start position

    return frame;
  }

  private void createComponents(Container container) {
    panel = new MainBorderLayoutPanel();
    centerPanel = new JPanel(new GridLayout(1, 1));
    list = new JList();
    buttonShow = new JButton("Show");
    buttonClick = new JButton("Click");

    addListener();
    scrollPane = new JScrollPane(list);
    centerPanel.add(scrollPane);

    panel.setSouth(new GridLayout(1, 2));
    panel.getSouth().add(buttonShow);
    panel.getSouth().add(buttonClick);

    panel.setCenter(new GridLayout(1, 1));
    panel.getCenter().add(centerPanel);
    panel.addToPanel();
    container.add(panel.getPanel());
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

  private void addListener() {
    buttonShow.addActionListener(new ShowButtonActionListener(list));
    buttonClick.addActionListener(new ClickButtonActionListener());
  }
}